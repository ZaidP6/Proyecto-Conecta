package com.salesianostriana.dam.conectapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@ComponentScan(basePackages = "com.salesianostriana.dam.conectapp")
@SpringBootApplication
@OpenAPIDefinition(info =
@Info(description = "API de la aplicación Conectapp para la gestión de y distribución de prácticas en empresa para alumnos de FP",
		version = "1.0",
		title = "API Conectapp"
)
)
public class ConectappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConectappApplication.class, args);
	}

}
