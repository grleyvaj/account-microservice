package com.devsu.account_service.domain.use_cases.account.detail;

import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.models.Account;
import com.devsu.account_service.domain.models.AccountInfo;
import com.devsu.account_service.domain.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountDetailUseCase {

	private final AccountRepository accountRepository;

	public AccountInfo execute(String customerId) throws ResourceNotFoundException {
		return this.accountRepository.findById(customerId).orElseThrow(
		  () -> new ResourceNotFoundException("Account %s not found".formatted(customerId))
		);
	}

}
