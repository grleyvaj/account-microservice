package com.devsu.account_service.application.controller.account.detail;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.models.Account;
import com.devsu.account_service.domain.models.AccountInfo;
import com.devsu.account_service.domain.models.Customer;

public class AccountDetailResponseMapper implements Mapper<AccountInfo, AccountDetailResponse> {

	@Override
	public AccountDetailResponse map(AccountInfo model) {
		Account account = model.getAccount();
		Customer customer = model.getCustomer();

		return new AccountDetailResponse()
		  .setId(account.getId())
		  .setCustomer(customer.getName())
		  .setNumber(account.getNumber())
		  .setType(account.getType().getName())
		  .setHomeBalance(account.getHomeBalance())
		  .setAvailableBalance(account.getAvailableBalance())
		  .setAlias(account.getAlias())
		  .setState(account.getIsActive());
	}

}
