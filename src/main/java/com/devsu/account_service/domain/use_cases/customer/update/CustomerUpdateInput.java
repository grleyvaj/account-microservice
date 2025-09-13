package com.devsu.account_service.domain.use_cases.customer.update;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerUpdateInput {

	private final String clientId;
	private final String name;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

}
