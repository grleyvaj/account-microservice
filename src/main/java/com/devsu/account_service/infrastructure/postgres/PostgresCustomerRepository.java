package com.devsu.account_service.infrastructure.postgres;

import com.devsu.account_service.domain.models.Customer;
import com.devsu.account_service.domain.repository.CustomerRepository;
import com.devsu.account_service.domain.use_cases.customer.create.CustomerCreateInput;
import com.devsu.account_service.domain.use_cases.customer.update.CustomerUpdateInput;
import com.devsu.account_service.infrastructure.entity.CustomerEntity;
import com.devsu.account_service.infrastructure.persistence.JpaCustomerRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
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

	@Override
	public void create(CustomerCreateInput createInput) {
		CustomerEntity entity = new CustomerEntity();
		entity.setClientId(createInput.getClientId());
		entity.setName(createInput.getName());
		entity.setCreatedAt(createInput.getCreatedAt());
		entity.setUpdatedAt(createInput.getCreatedAt());
		this.jpaCustomerRepository.save(entity);
	}

	@Override
	public void update(CustomerUpdateInput updateInput) {
		this.jpaCustomerRepository
		  .findByClientIdAndIsDeletedFalse(updateInput.getClientId())
		  .ifPresent(entity -> {
			  entity.setName(updateInput.getName());
			  entity.setCreatedAt(updateInput.getCreatedAt());
			  entity.setUpdatedAt(updateInput.getUpdatedAt());
			  this.jpaCustomerRepository.save(entity);
		  });
	}

	@Override
	public void delete(String clientId, LocalDateTime deletedAt) {
		this.jpaCustomerRepository
		  .findByClientIdAndIsDeletedFalse(clientId)
		  .ifPresent(entity -> {
			  entity.setIsDeleted(Boolean.TRUE);
			  entity.setDeletedAt(deletedAt);
			  this.jpaCustomerRepository.save(entity);
		  });
	}

}
