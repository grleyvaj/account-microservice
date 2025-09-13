package com.devsu.account_service.domain.use_cases.customer.update;

import com.devsu.account_service.domain.models.Customer;
import com.devsu.account_service.domain.repository.CustomerRepository;
import com.devsu.account_service.domain.repository.CustomerUpsertInput;
import com.devsu.account_service.domain.use_cases.customer.create.CustomerCreateInput;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CustomerUpdateUseCase {

	private final CustomerRepository customerRepository;

	public void execute(CustomerUpdateInput updateInput) {
		Optional<Customer> byClientId = this.customerRepository.findByClientId(updateInput.getClientId());

		byClientId.ifPresentOrElse(
		  customer -> this.customerRepository.update(
			new CustomerUpsertInput(
			  updateInput.getClientId(),
			  updateInput.getName(),
			  updateInput.getCreatedAt(),
			  updateInput.getCreatedAt()
			)
		  ),
		  () -> this.customerRepository.create(
			new CustomerCreateInput(
			  updateInput.getClientId(),
			  updateInput.getName(),
			  updateInput.getCreatedAt()
			)
		  )
		);
	}

}
