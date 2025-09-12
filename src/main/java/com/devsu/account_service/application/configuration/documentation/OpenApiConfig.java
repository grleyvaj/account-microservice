package com.devsu.account_service.application.configuration.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Configuration
@PropertySource("classpath:${openapi.language}")
class OpenApiConfig {

	private final OpenApiProperties props;
	private final Optional<BuildProperties> buildProperties;

	public static String DEFAULT_INFO_TITLE = "API";
	public static String DEFAULT_INFO_DESCRIPTION = "Crud API";
	public static String DEFAULT_VERSION = "1.0";

	public OpenApiConfig(OpenApiProperties props, Optional<BuildProperties> buildProperties) {
		this.props = props;
		this.buildProperties = buildProperties;
	}

	@Bean
	public OpenAPI openAPI() {
		Info info = new Info()
		  .title(nonNull(props.getInfo()) ? props.getInfo().getTitle() : DEFAULT_INFO_TITLE)
		  .description(props.getInfo() != null ? props.getInfo().getDescription() : DEFAULT_INFO_DESCRIPTION)
		  .version(buildProperties.map(BuildProperties::getVersion).orElse(DEFAULT_VERSION));

		if(nonNull(props.getInfo()) && nonNull(props.getInfo().getContact())) {
			OpenApiProperties.Contact contact = props.getInfo().getContact();
			info.setContact(new Contact().name(contact.getName()).email(contact.getEmail()));
		}

		List<Server> servers = props.getServers().stream()
		  .map(s -> new Server().url(s.getUrl()).description(s.getDescription()))
		  .toList();

		OpenAPI openAPI = new OpenAPI()
		  .info(info)
		  .components(new Components());

		if(!servers.isEmpty()) {
			openAPI.setServers(servers);
		}

		return openAPI;
	}

}