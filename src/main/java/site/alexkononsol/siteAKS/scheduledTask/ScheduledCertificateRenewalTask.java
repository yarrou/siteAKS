package site.alexkononsol.siteAKS.scheduledTask;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@Slf4j
@Component
@EnableScheduling
public class ScheduledCertificateRenewalTask {

    private final String webRootPath;
    private final String certsRenewCommand;

    public ScheduledCertificateRenewalTask(@Value("${WEB_ROOT}") String webRootPath,
                                           @Value("${cert.renew.command}") String certsRenewCommand) {
        this.webRootPath = webRootPath;
        this.certsRenewCommand = certsRenewCommand;
    }

    @Scheduled(fixedRate = 86_400_000) // task runs every 24 hours
    public void updateCerts() throws InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();

        builder.command("sh", "-c",String.format(certsRenewCommand,webRootPath));
        try {
            Process process = builder.start();
            StreamGobbler streamGobbler =
                    new StreamGobbler(process.getInputStream(),log::info );
            Executors.newSingleThreadExecutor().submit(streamGobbler);
            int exitCode = process.waitFor();
            assert exitCode == 0;
        } catch (IOException e) {
            log.error("failed to update certificates",e);
        }


    }
    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }
}