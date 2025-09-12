package com.devsu.account_service.application.beans;

import com.devsu.account_service.domain.repository.AccountRepository;
import com.devsu.account_service.domain.repository.CustomerRepository;
import com.devsu.account_service.domain.use_cases.account.create.AccountCreateUseCase;
import com.devsu.account_service.domain.use_cases.account.detail.AccountDetailUseCase;
import com.devsu.account_service.domain.use_cases.account.update.AccountUpdateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCases {

	@Bean
	public AccountCreateUseCase accountCreateUseCase(
	  CustomerRepository customerRepository,
	  AccountRepository accountRepository
	) {
		return new AccountCreateUseCase(customerRepository, accountRepository);
	}

	@Bean
	public AccountDetailUseCase accountDetailUseCase(AccountRepository accountRepository) {
		return new AccountDetailUseCase(accountRepository);
	}

	@Bean
	public AccountUpdateUseCase accountUpdateUseCase(AccountRepository accountRepository) {
		return new AccountUpdateUseCase(accountRepository);
	}

}
