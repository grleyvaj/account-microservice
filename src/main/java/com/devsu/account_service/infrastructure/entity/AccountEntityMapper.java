package com.devsu.account_service.infrastructure.entity;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.helpers.Generator;
import com.devsu.account_service.domain.use_cases.account.create.AccountCreateInput;

import java.time.LocalDateTime;

import static java.util.Objects.nonNull;

public class AccountEntityMapper implements Mapper<AccountCreateInput, AccountEntity> {

	@Override
	public AccountEntity map(AccountCreateInput createInput) {
		LocalDateTime current = LocalDateTime.now();

		var available = nonNull(createInput.getAvailableBalance())
		  ? createInput.getAvailableBalance()
		  : createInput.getHomeBalance();

		return (AccountEntity)new AccountEntity()
		  .setId(Generator.ulid())
		  .setClientId(createInput.getClientId())
		  .setAccountNumber(createInput.getNumber())
		  .setAlias(createInput.getAlias())
		  .setType(createInput.getType())
		  .setHomeBalance(createInput.getHomeBalance())
		  .setAvailableBalance(available)
		  .setIsActive(Boolean.TRUE)
		  .setCreatedAt(current)
		  .setUpdatedAt(current);
	}

}
