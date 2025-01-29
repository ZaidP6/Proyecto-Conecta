package com.salesianostriana.dam.conectapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.salesianostriana.dam.conectapp")
@SpringBootApplication
public class ConectappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConectappApplication.class, args);
	}

}
