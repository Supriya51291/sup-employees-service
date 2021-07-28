package com.sup.employees.config;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	private String version = "1.0";
	private String title = "Sup-Employees-Backend-Application";
	private String description = "Sample project to test Database connectivity & Swagger Documentation";
	private String basePackage = "com.sup.employees";

	@Value("${swagger.is.enable}")
	private boolean swagger_is_enable;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).enable(swagger_is_enable).select()
				.apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.any()).build()
				.directModelSubstitute(LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(LocalDateTime.class, java.util.Date.class).apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(title).description(description).version(version).build();
	}

}