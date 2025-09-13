package com.devsu.account_service.application.listener.customer.message;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class CustomerDeletedMessage implements Serializable {

	private final String clientId;
	private final LocalDateTime deletedAt;

}
