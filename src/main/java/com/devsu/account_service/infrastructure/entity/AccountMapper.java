package com.devsu.account_service.infrastructure.entity;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.models.Account;

public class AccountMapper implements Mapper<AccountEntity, Account> {

	@Override
	public Account map(AccountEntity accountEntity) {

		return new Account(
		  accountEntity.getId(),
		  accountEntity.getAccountNumber(),
		  accountEntity.getType(),
		  accountEntity.getHomeBalance(),
		  accountEntity.getAvailableBalance(),
		  accountEntity.getIsActive()
		)
		  .setAlias(accountEntity.getAlias());
	}

}
