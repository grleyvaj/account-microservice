package com.devsu.account_service.infrastructure.entity;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.models.Account;
import com.devsu.account_service.domain.models.AccountInfo;
import com.devsu.account_service.domain.models.Customer;

public class AccountInfoMapper implements Mapper<AccountEntity, AccountInfo> {

	@Override
	public AccountInfo map(AccountEntity accountEntity) {
		CustomerEntity customerEntity = accountEntity.getCustomer();

		return new AccountInfo(
		  new Customer(
			customerEntity.getClientId(),
			customerEntity.getName()
		  ),
		  new Account(
			accountEntity.getId(),
			accountEntity.getClientId(),
			accountEntity.getAccountNumber(),
			accountEntity.getType(),
			accountEntity.getHomeBalance(),
			accountEntity.getAvailableBalance(),
			accountEntity.getIsActive()
		  ).setAlias(accountEntity.getAlias())
		);
	}

}
