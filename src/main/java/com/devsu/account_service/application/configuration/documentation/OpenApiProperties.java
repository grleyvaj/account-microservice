package com.devsu.account_service.application.configuration.documentation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "openapi")
public class OpenApiProperties {

	private List<Server> servers = new ArrayList<>();
	private Info info = new Info();
	private String language;

	@Data
	public static class Server {
		private String url;
		private String description;
	}

	@Data
	public static class Info {
		private String title;
		private String description;
		private String version;
		private Contact contact = new Contact();
	}

	@Data
	public static class Contact {
		private String name;
		private String email;
	}

}