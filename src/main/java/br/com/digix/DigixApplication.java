package br.com.digix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.br.entities"})
public class DigixApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigixApplication.class, args);
	}

}
