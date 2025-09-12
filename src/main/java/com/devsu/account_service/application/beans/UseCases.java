package com.devsu.account_service.application.beans;

import com.devsu.account_service.domain.repository.AccountRepository;
import com.devsu.account_service.domain.repository.CustomerRepository;
import com.devsu.account_service.domain.repository.MovementRepository;
import com.devsu.account_service.domain.use_cases.account.create.AccountCreateUseCase;
import com.devsu.account_service.domain.use_cases.account.detail.AccountDetailUseCase;
import com.devsu.account_service.domain.use_cases.account.list.AccountActivesUseCase;
import com.devsu.account_service.domain.use_cases.account.update.AccountUpdateUseCase;
import com.devsu.account_service.domain.use_cases.movement.create.MovementCreateUseCase;
import com.devsu.account_service.domain.use_cases.movement.detail.MovementDetailUseCase;
import com.devsu.account_service.domain.use_cases.report.ClientReportUseCase;
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

	@Bean
	public MovementCreateUseCase movementCreateUseCase(
	  AccountRepository accountRepository,
	  MovementRepository movementRepository
	) {
		return new MovementCreateUseCase(
		  accountRepository,
		  movementRepository
		);
	}

	@Bean
	public MovementDetailUseCase movementDetailUseCase(MovementRepository movementRepository) {
		return new MovementDetailUseCase(movementRepository);
	}

	@Bean
	public AccountActivesUseCase accountActivesUseCase(AccountRepository accountRepository) {
		return new AccountActivesUseCase(accountRepository);
	}

	@Bean
	public ClientReportUseCase clientReportUseCase(
	  CustomerRepository customerRepository,
	  MovementRepository movementRepository
	) {
		return new ClientReportUseCase(
		  customerRepository,
		  movementRepository
		);
	}
}
