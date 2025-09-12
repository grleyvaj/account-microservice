package com.devsu.account_service.domain.models;

public enum MovementType {

	DEPOSIT("Deposit"),
	WITHDRAWAL("Withdrawal");

	private final String name;

	MovementType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
