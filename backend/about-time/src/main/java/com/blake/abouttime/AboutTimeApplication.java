package com.blake.abouttime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AboutTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AboutTimeApplication.class, args);
	}

}
