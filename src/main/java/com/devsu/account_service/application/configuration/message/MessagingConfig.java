package com.devsu.account_service.application.configuration.message;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Data
@Configuration
@ConfigurationProperties(prefix = "messaging.customer")
@Validated
public class MessagingConfig {

	private String exchange;
	private MessagingTopicRouting created;
	private MessagingTopicRouting updated;
	private MessagingTopicRouting deleted;

}
