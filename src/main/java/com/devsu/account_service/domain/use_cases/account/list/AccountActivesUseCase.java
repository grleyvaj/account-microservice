package com.devsu.account_service.domain.use_cases.account.list;

import com.devsu.account_service.domain.models.Account;
import com.devsu.account_service.domain.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AccountActivesUseCase {

	private final AccountRepository accountRepository;

	public List<Account> execute(String clientId) {
		return this.accountRepository.findActiveAll(clientId);
	}

}
