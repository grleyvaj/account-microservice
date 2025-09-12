package com.devsu.account_service.application.beans;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.models.Account;
import com.devsu.account_service.domain.models.AccountInfo;
import com.devsu.account_service.domain.repository.AccountRepository;
import com.devsu.account_service.domain.repository.CustomerRepository;
import com.devsu.account_service.domain.use_cases.account.create.AccountCreateInput;
import com.devsu.account_service.infrastructure.entity.AccountEntity;
import com.devsu.account_service.infrastructure.entity.AccountEntityCreator;
import com.devsu.account_service.infrastructure.persistence.JpaAccountRepository;
import com.devsu.account_service.infrastructure.persistence.JpaCustomerRepository;
import com.devsu.account_service.infrastructure.postgres.PostgresAccountRepository;
import com.devsu.account_service.infrastructure.postgres.PostgresCustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Repositories {

	@Bean
	public AccountRepository accountRepository(
	  JpaAccountRepository jpaAccountRepository,
	  JpaCustomerRepository jpaCustomerRepository,
	  AccountEntityCreator accountCreator,
	  Mapper<AccountCreateInput, AccountEntity> accountEntityMapper,
	  Mapper<AccountEntity, Account> accountMapper,
	  Mapper<AccountEntity, AccountInfo> accountInfoMapper
	) {
		return new PostgresAccountRepository(
		  jpaAccountRepository,
		  jpaCustomerRepository,
		  accountCreator,
		  accountEntityMapper,
		  accountMapper,
		  accountInfoMapper
		);
	}

	@Bean
	public CustomerRepository customerRepository(JpaCustomerRepository jpaCustomerRepository) {
		return new PostgresCustomerRepository(jpaCustomerRepository);
	}

}
