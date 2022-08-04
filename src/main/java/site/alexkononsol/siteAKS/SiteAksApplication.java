package site.alexkononsol.siteAKS;

import de.dentrassi.crypto.pem.PemKeyStoreProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Security;

@SpringBootApplication
public class SiteAksApplication {

	public static void main(String[] args) {
		Security.addProvider(new PemKeyStoreProvider());
		SpringApplication.run(SiteAksApplication.class, args);
	}

}
