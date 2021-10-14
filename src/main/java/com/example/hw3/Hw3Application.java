package com.example.hw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.hw3.properties")
public class Hw3Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw3Application.class, args);
	}

}
