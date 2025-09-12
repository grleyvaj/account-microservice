package com.devsu.account_service.domain.models;

import lombok.Data;

@Data
public class MovementInfo {

	private final Customer customer;
	private final Account account;
	private final Movement movement;

}
