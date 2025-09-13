package com.devsu.account_service.domain.use_cases.customer.create;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerCreateInput {

	private final String clientId;
	private final String name;
	private final LocalDateTime createdAt;

}
