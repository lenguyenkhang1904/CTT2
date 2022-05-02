package com.example.CDTT2.Swagger;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.securitySchemes(Arrays.asList(apiKey()))
				.securityContexts(Arrays.asList(securityContext()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.CDTT2"))
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo()
	{
		return new ApiInfoBuilder()
    			.title("CDTT2 Application")
    			.description("CDTT2 for education")
    			.contact(new Contact("Lê Ngô Nguyên Khang","KM19","11951150072@sv.ut.edu.vn"))
    			.license("MIT2")
    			.build();
	}
	
	public ApiKey apiKey()
	{
		return new ApiKey("JWT", "Authorization", "header");
	}
	
    private SecurityContext securityContext()
    {
    	return SecurityContext.builder()
    			.securityReferences(securityReferences()).build();            // builder(): ko tạo instance liền mà bắt mình nhập thông tin trước xong sau đó mới tạo 
    }
	
	 private List<SecurityReference> securityReferences()
	    {
	    	AuthorizationScope authorizationScope=new AuthorizationScope("global", "All application can access"); //
	    	
	    	AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
	    	
	    	authorizationScopes[0]=authorizationScope;
	    	
	    	return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); //string refference là tham chiếu tới apiKey nào
	    }
	
}
