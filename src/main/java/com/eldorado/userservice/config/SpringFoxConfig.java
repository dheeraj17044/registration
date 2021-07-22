package com.eldorado.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.eldorado.userservice.controller"))
				.paths(regex("/user.*"))
				.build()
				.apiInfo(metaData());
    }

	private ApiInfo metaData() {
		ApiInfo apiInfo=new ApiInfo(
				"Spring Boot REST API",
				"Spring Boot REST API for EL DORADO App",
				"1.0",
				"Terms of service",
				new Contact("BATCH 1","https://tools.publicis.sapient.com/bitbucket/projects/PSMS/repos/product-phase","xyz@publicissapient.com"),
				"Apache License Version 2.2",
				"https://www.eldorado.com");
				
				return apiInfo;
				
	}
}