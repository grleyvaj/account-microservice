package com.devsu.account_service.domain.use_cases.account.create;

import com.devsu.account_service.domain.models.AccountType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class AccountCreateInput {

	private final String clientId;
	private final String number;
	private final AccountType type;
	private final BigDecimal homeBalance;
	private String alias;

}
