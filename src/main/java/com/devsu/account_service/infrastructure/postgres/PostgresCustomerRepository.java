package com.devsu.account_service.infrastructure.postgres;

import com.devsu.account_service.domain.models.Customer;
import com.devsu.account_service.domain.repository.CustomerRepository;
import com.devsu.account_service.infrastructure.persistence.JpaCustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class PostgresCustomerRepository implements CustomerRepository {

	private final JpaCustomerRepository jpaCustomerRepository;


	@Override
	public boolean existsByClientId(String clientId) {
		return this.jpaCustomerRepository.existsByClientIdAndIsDeletedFalse(clientId);
	}

	@Override
	public Optional<Customer> findByClientId(String clientId) {
		return this.jpaCustomerRepository.findByClientIdAndIsDeletedFalse(clientId)
		  .map(customerEntity -> new Customer(customerEntity.getClientId(), customerEntity.getName()));
	}

}
