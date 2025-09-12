package com.devsu.account_service.infrastructure.postgres;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.models.Account;
import com.devsu.account_service.domain.models.AccountInfo;
import com.devsu.account_service.domain.repository.AccountRepository;
import com.devsu.account_service.domain.use_cases.account.create.AccountCreateInput;
import com.devsu.account_service.domain.use_cases.account.update.AccountUpdateInput;
import com.devsu.account_service.infrastructure.entity.AccountEntity;
import com.devsu.account_service.infrastructure.entity.AccountEntityCreator;
import com.devsu.account_service.infrastructure.persistence.JpaAccountRepository;
import com.devsu.account_service.infrastructure.persistence.JpaCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class PostgresAccountRepository implements AccountRepository {

	private final JpaAccountRepository jpaAccountRepository;
	private final JpaCustomerRepository jpaCustomerRepository;
	private final AccountEntityCreator accountEntityCreator;
	private final Mapper<AccountCreateInput, AccountEntity> accountEntityMapper;
	private final Mapper<AccountEntity, Account> accountMapper;
	private final Mapper<AccountEntity, AccountInfo> accountInfoMapper;

	/*@Override
	public Account create(AccountCreateInput createInput) throws ResourceNotFoundException {
		CustomerEntity customerEntity = this.jpaCustomerRepository.findByClientIdAndIsDeletedFalse(createInput.getClientId())
		  .orElseThrow(() -> new ResourceNotFoundException("Client %s not found".formatted(createInput.getClientId())));

		AccountEntity accountEntity = this.jpaAccountRepository.save(
		  this.accountEntityCreator.create(customerEntity, createInput)
		);

		return this.accountMapper.map(accountEntity);
	}*/

	@Override
	public Account create(AccountCreateInput createInput) {
		return this.accountMapper.map(
		  this.jpaAccountRepository.save(
			this.accountEntityMapper.map(createInput)
		  )
		);
	}

	@Override
	public boolean existsByNumber(String number) {
		return this.jpaAccountRepository.existsByAccountNumberAndIsDeletedFalse(number);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<AccountInfo> findById(String accountId) {
		return this.jpaAccountRepository.findByIdAndIsDeletedFalse(accountId)
		  .map(this.accountInfoMapper::map);
	}

	@Override
	@Transactional
	public AccountInfo update(
	  String accountId,
	  AccountUpdateInput accountUpdateInput
	) throws ResourceNotFoundException {
		AccountEntity accountEntity = this.jpaAccountRepository.findByIdAndIsDeletedFalse(accountId)
		  .orElseThrow(() -> new ResourceNotFoundException("Account %s not found".formatted(accountId)));

		boolean changed = false;

		if(accountUpdateInput.getAlias().isPresent()) {
			String newAlias = accountUpdateInput.getAlias().get();
			if(!Objects.equals(accountEntity.getAlias(), newAlias)) {
				accountEntity.setAlias(newAlias);
				changed = true;
			}
		}

		if(accountUpdateInput.getState().isPresent()) {
			Boolean newState = accountUpdateInput.getState().get();
			if(!Objects.equals(accountEntity.getIsActive(), newState)) {
				accountEntity.setIsActive(newState);
				changed = true;
			}
		}

		if(changed) {
			accountEntity.setUpdatedAt(LocalDateTime.now());
			accountEntity = this.jpaAccountRepository.save(accountEntity);
		}

		return this.accountInfoMapper.map(
		  this.jpaAccountRepository.save(accountEntity)
		);
	}

}
