package com.devsu.account_service.domain.use_cases.customer.delete;

import com.devsu.account_service.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class CustomerDeleteUseCase {

	private final CustomerRepository customerRepository;

	public void execute(String clientId, LocalDateTime deletedAt) {
		this.customerRepository.delete(clientId, deletedAt);
	}

}
