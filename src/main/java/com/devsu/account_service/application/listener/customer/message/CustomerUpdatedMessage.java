package com.devsu.account_service.application.listener.customer.message;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class CustomerUpdatedMessage implements Serializable {

	private final String clientId;
	private final String name;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

}
