package com.devsu.account_service.domain.use_cases.account.update;

import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.models.AccountInfo;
import com.devsu.account_service.domain.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountUpdateUseCase {

	private final AccountRepository accountRepository;

	public AccountInfo execute(
	  String accountId,
	  AccountUpdateInput accountUpdateInput
	) throws ResourceNotFoundException {
		return this.accountRepository.update(accountId, accountUpdateInput);
	}

}
