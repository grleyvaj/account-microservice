package com.devsu.account_service.domain.models;

public enum AccountType {

	SAVINGS("Savings"),
	CURRENT("Current");

	private final String name;

	AccountType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
