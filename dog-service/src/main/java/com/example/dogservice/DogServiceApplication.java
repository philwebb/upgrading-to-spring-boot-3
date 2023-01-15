package com.example.dogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.SanitizableData;
import org.springframework.boot.actuate.endpoint.SanitizingFunction;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

/**
 * Main application entry point.
 */
@SpringBootApplication(proxyBeanMethods = false)
@ConfigurationPropertiesScan
public class DogServiceApplication {

	@Bean
	SanitizingFunction sanitizingFunction() {
		return (data) -> (data.getKey().toLowerCase().contains("password"))
				? data.withValue(SanitizableData.SANITIZED_VALUE)
				: data;
	}

	public static void main(String[] args) {
		SpringApplication.run(DogServiceApplication.class, args);
	}

}
