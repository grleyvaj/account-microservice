package com.devsu.account_service.application.controller.account.create;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.use_cases.account.create.AccountCreateInput;

import java.util.Optional;

public class AccountCreateInputMapper implements Mapper<AccountCreateRequest, AccountCreateInput> {

	@Override
	public AccountCreateInput map(AccountCreateRequest request) {
		AccountCreateInput createInput = new AccountCreateInput(
		  request.getClientId(),
		  request.getNumber(),
		  request.getType(),
		  request.getHomeBalance()
		);

		Optional.ofNullable(request.getAlias()).ifPresent(createInput::setAlias);

		return createInput;
	}

}
