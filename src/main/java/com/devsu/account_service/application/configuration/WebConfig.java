package com.devsu.account_service.application.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {


	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
		  .addMapping("/**")
		  .allowedOrigins("*")
		  .allowedMethods("POST", "GET", "PUT", "PATCH", "DELETE")
		  .allowedHeaders(
			"Accept",
			"Accept-Version",
			"Content-Length",
			"Content-Type",
			"Authorization"
		  )
		  .maxAge(3600);
	}

}