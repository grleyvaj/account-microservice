package com.devsu.account_service.domain.repository;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerUpsertInput {

	private final String clientId;
	private final String name;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

}
