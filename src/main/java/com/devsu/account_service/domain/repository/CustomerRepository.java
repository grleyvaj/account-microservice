package com.devsu.account_service.domain.repository;

import com.devsu.account_service.domain.models.Customer;

import java.util.Optional;

public interface CustomerRepository {

	boolean existsByClientId(String clientId);

	Optional<Customer> findByClientId(String clientId);

}
