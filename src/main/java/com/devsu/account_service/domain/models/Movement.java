package com.devsu.account_service.domain.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Movement {

	private final String id;
	private final MovementType type;
	private final LocalDateTime executionDate;
	private final BigDecimal amount;
	private final BigDecimal balanceBefore;
	private final BigDecimal balanceAfter;
	private final boolean state;

	public String getDescription() {
		return type.getName() + " of " + amount;
	}

}
