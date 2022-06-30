package com.gustosmusicales.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(title="Api Rest para encuesta de gustos musicales")
		)
@SecurityScheme(
	    name = "apiKey",
	    type = SecuritySchemeType.APIKEY,
	    scheme = "api-key",
	    in = SecuritySchemeIn.HEADER
	)
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
