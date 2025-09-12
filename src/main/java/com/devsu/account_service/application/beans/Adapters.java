package com.devsu.account_service.application.beans;

import com.devsu.account_service.application.contract.ListMapper;
import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.application.controller.account.create.AccountCreateInputMapper;
import com.devsu.account_service.application.controller.account.create.AccountCreateRequest;
import com.devsu.account_service.application.controller.account.detail.AccountDetailResponse;
import com.devsu.account_service.application.controller.account.detail.AccountDetailResponseMapper;
import com.devsu.account_service.application.controller.account.list.AccountSummaryResponse;
import com.devsu.account_service.application.controller.account.list.AccountSummaryResponseMapper;
import com.devsu.account_service.application.controller.account.update.AccountUpdateInputMapper;
import com.devsu.account_service.application.controller.account.update.AccountUpdateRequest;
import com.devsu.account_service.application.controller.movement.create.MovementCreateInputMapper;
import com.devsu.account_service.application.controller.movement.create.MovementCreateRequest;
import com.devsu.account_service.application.controller.movement.detail.MovementDetailResponse;
import com.devsu.account_service.application.controller.movement.detail.MovementDetailResponseMapper;
import com.devsu.account_service.application.controller.pagination.response.PageResponse;
import com.devsu.account_service.application.controller.pagination.response.PageResponseMapper;
import com.devsu.account_service.domain.models.Account;
import com.devsu.account_service.domain.models.AccountInfo;
import com.devsu.account_service.domain.models.Movement;
import com.devsu.account_service.domain.pagination.Pagination;
import com.devsu.account_service.domain.use_cases.account.create.AccountCreateInput;
import com.devsu.account_service.domain.use_cases.account.update.AccountUpdateInput;
import com.devsu.account_service.domain.use_cases.movement.create.MovementCreateInput;
import com.devsu.account_service.infrastructure.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Adapters {

	@Bean
	public Mapper<AccountCreateRequest, AccountCreateInput> accountCreateInputMapper() {
		return new AccountCreateInputMapper();
	}

	@Bean
	public Mapper<AccountInfo, AccountDetailResponse> accountDetailResponseMapper() {
		return new AccountDetailResponseMapper();
	}

	@Bean
	public Mapper<AccountUpdateRequest, AccountUpdateInput> accountUpdateInputMapper() {
		return new AccountUpdateInputMapper();
	}

	@Bean
	public Mapper<AccountEntity, Account> accountMapper() {
		return new AccountMapper();
	}

	@Bean
	public Mapper<Pagination, PageResponse> pageResponseMapper() {
		return new PageResponseMapper();
	}

	@Bean
	public Mapper<AccountCreateInput, AccountEntity> accountEntityMapper() {
		return new AccountEntityMapper();
	}

	@Bean
	public Mapper<AccountEntity, AccountInfo> accountInfoMapper() {
		return new AccountInfoMapper();
	}

	@Bean
	public Mapper<MovementCreateRequest, MovementCreateInput> movementCreateInputMapper() {
		return new MovementCreateInputMapper();
	}

	@Bean
	public Mapper<MovementCreateInput, MovementEntity> movementEntityMapper() {
		return new MovementEntityMapper();
	}

	@Bean
	public Mapper<MovementEntity, Movement> movementMapper() {
		return new MovementMapper();
	}

	@Bean
	public Mapper<Movement, MovementDetailResponse> movementDetailResponseMapper() {
		return new MovementDetailResponseMapper();
	}

	@Bean
	public Mapper<Account, AccountSummaryResponse> accountSummaryResponseMapper() {
		return new AccountSummaryResponseMapper();
	}

	@Bean
	public ListMapper<Account, AccountSummaryResponse> accountSummaryResponseListMapper(
	  Mapper<Account, AccountSummaryResponse> accountSummaryResponseMapper
	) {
		return new ListMapper<>(accountSummaryResponseMapper);
	}

}
