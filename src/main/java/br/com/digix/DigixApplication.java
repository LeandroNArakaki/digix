package br.com.digix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"br.com.entity"})
@ComponentScan(basePackages = {"br.com"})
@EnableJpaRepositories(basePackages = {"br.com.repository"})
public class DigixApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigixApplication.class, args);
	}

}
