package com.devsu.account_service.application.listener.customer.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class CustomerDeletedMessage implements Serializable {

	@JsonProperty("client_id")
	private final String clientId;

	@JsonProperty("deleted_at")
	private final LocalDateTime deletedAt;

}
