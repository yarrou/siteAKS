package site.alexkononsol.siteAKS.reloadingSertificates;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.core.env.Environment;

//https://github.com/mjeffrey/pem-keystore-reload
@Slf4j
public class ReloadableServletFactory extends TomcatServletWebServerFactory {

    public static ReloadableServletFactory create(Environment environment) {
        setMonitoredPemFileLocations(environment);
        ReloadableServletFactory factory = new ReloadableServletFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        factory.addAdditionalTomcatConnectors(getHttpConnector());
        factory.setProtocol(ReloadProtocol.class.getName());
        return factory;
    }

    @Override
    protected void customizeConnector(Connector connector) {
        super.customizeConnector(connector);
    }

    @SneakyThrows
    private static void setMonitoredPemFileLocations(Environment environment) {
        String keyStoreLocation = environment.getProperty("server.ssl.key-store");
        KeyStoreMonitoredPaths.addPaths(keyStoreLocation);
    }

    private static Connector getHttpConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(80);
        connector.setSecure(false);
        connector.setRedirectPort(443);
        return connector;
    }
}
