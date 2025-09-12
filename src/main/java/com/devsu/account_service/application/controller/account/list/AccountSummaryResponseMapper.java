package com.devsu.account_service.application.controller.account.list;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.models.Account;

public class AccountSummaryResponseMapper implements Mapper<Account, AccountSummaryResponse> {

	@Override
	public AccountSummaryResponse map(Account model) {
		return new AccountSummaryResponse()
		  .setNumber(model.getNumber())
		  .setType(model.getType().getName())
		  .setHomeBalance(model.getHomeBalance())
		  .setAvailableBalance(model.getAvailableBalance())
		  .setAlias(model.getAlias());
	}

}
