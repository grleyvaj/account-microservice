package com.devsu.account_service.infrastructure.entity;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.helpers.Generator;
import com.devsu.account_service.domain.use_cases.account.create.AccountCreateInput;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountEntityMapper implements Mapper<AccountCreateInput, AccountEntity> {

	@Override
	public AccountEntity map(AccountCreateInput createInput) {
		LocalDateTime current = LocalDateTime.now();

		return (AccountEntity)new AccountEntity()
		  .setId(Generator.ulid())
		  .setClientId(createInput.getClientId())
		  .setAccountNumber(createInput.getNumber())
		  .setAlias(createInput.getAlias())
		  .setType(createInput.getType())
		  .setHomeBalance(createInput.getHomeBalance())
		  .setAvailableBalance(BigDecimal.valueOf(0L))
		  .setIsActive(Boolean.TRUE)
		  .setCreatedAt(current)
		  .setUpdatedAt(current);

	}

}
