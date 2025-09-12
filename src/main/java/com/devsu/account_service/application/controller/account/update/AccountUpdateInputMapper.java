package com.devsu.account_service.application.controller.account.update;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.use_cases.account.update.AccountUpdateInput;

import java.util.Optional;

public class AccountUpdateInputMapper implements Mapper<AccountUpdateRequest, AccountUpdateInput> {

	@Override
	public AccountUpdateInput map(AccountUpdateRequest request) {
		AccountUpdateInput createInput = new AccountUpdateInput();

		Optional.ofNullable(request.getState()).ifPresent(createInput::setState);
		Optional.ofNullable(request.getAlias()).ifPresent(createInput::setAlias);

		return createInput;
	}

}
