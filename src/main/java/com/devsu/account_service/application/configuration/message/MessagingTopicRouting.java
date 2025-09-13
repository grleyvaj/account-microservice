package com.devsu.account_service.application.configuration.message;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

@Data
@Accessors(chain = true)
@Validated
public class MessagingTopicRouting {

	@NotEmpty
	private String queue;

	@NotEmpty
	private String routingKey;

}
