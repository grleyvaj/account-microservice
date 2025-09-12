package com.devsu.account_service.domain.use_cases.account.create;

import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.models.AccountInfo;
import com.devsu.account_service.domain.models.Customer;
import com.devsu.account_service.domain.repository.AccountRepository;
import com.devsu.account_service.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountCreateUseCase {

	private final CustomerRepository customerRepository;
	private final AccountRepository accountRepository;

	public AccountInfo execute(AccountCreateInput createInput) throws ResourceNotFoundException {
		Customer customer = this.customerRepository.findByClientId(createInput.getClientId())
		  .orElseThrow(() -> new ResourceNotFoundException("Client %s not found".formatted(createInput.getClientId())));

		return new AccountInfo(customer, this.accountRepository.create(createInput));
	}

}
