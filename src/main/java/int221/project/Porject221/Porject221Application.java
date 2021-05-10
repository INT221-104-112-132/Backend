package int221.project.Porject221;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import int221.project.Porject221.storageservices.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({StorageProperties.class})
public class Porject221Application {

	public static void main(String[] args) {
		SpringApplication.run(Porject221Application.class, args);
	}

}
