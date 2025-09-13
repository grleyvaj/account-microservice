package com.devsu.account_service.domain.use_cases.customer.create;

import com.devsu.account_service.domain.models.Customer;
import com.devsu.account_service.domain.repository.CustomerRepository;
import com.devsu.account_service.domain.repository.CustomerUpsertInput;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CustomerCreateUseCase {

	private final CustomerRepository customerRepository;

	public void execute(CustomerCreateInput createInput) {
		Optional<Customer> byClientId = this.customerRepository.findByClientId(createInput.getClientId());

		byClientId.ifPresentOrElse(
		  customer -> this.customerRepository.update(
			new CustomerUpsertInput(
			  createInput.getClientId(),
			  createInput.getName(),
			  createInput.getCreatedAt(),
			  createInput.getCreatedAt()
			)
		  ),
		  () -> this.customerRepository.create(createInput)
		);
	}

}
