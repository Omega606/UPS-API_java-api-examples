package com.ups.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ups.api")
public class AddressValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressValidationApplication.class, args);
	}

}
