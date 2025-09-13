package com.devsu.account_service.domain.use_cases.customer.create;

import com.devsu.account_service.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerCreateUseCase {

	private final CustomerRepository customerRepository;

	public void execute(CustomerCreateInput createInput) {
		this.customerRepository.create(createInput);
	}

}
