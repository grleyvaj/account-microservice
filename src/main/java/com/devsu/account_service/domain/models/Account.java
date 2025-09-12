package com.devsu.account_service.domain.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class Account {

	private final String id;
	private final String number;
	private final AccountType type;
	private final BigDecimal homeBalance;
	private final BigDecimal availableBalance;
	private final Boolean isActive;
	private String alias;

}
