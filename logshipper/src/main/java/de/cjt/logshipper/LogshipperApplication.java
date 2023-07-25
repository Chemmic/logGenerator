package de.cjt.logshipper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "de.cjt")

public class LogshipperApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogshipperApplication.class, args);
	}

}
