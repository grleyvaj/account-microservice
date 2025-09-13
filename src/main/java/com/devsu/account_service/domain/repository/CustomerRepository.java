package com.devsu.account_service.domain.repository;

import com.devsu.account_service.domain.models.Customer;
import com.devsu.account_service.domain.use_cases.customer.create.CustomerCreateInput;
import com.devsu.account_service.domain.use_cases.customer.update.CustomerUpdateInput;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CustomerRepository {

	boolean existsByClientId(String clientId);

	Optional<Customer> findByClientId(String clientId);

	void create(CustomerCreateInput createInput);

	void update(CustomerUpdateInput updateInput);

	void delete(String clientId, LocalDateTime deletedAt);

}
