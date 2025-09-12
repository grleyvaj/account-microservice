package com.devsu.account_service.domain.models;

import lombok.Data;

@Data
public class AccountInfo {

	private final Customer customer;
	private final Account account;

}
