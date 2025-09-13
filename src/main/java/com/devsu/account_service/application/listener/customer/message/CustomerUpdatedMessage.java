package com.devsu.account_service.application.listener.customer.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class CustomerUpdatedMessage implements Serializable {

	@JsonProperty("client_id")
	private final String clientId;

	@JsonProperty("name")
	private final String name;

	@JsonProperty("created_at")
	private final LocalDateTime createdAt;

	@JsonProperty("updated_at")
	private final LocalDateTime updatedAt;

}
