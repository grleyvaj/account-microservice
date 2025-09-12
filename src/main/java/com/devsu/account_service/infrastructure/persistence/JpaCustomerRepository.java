package com.devsu.account_service.infrastructure.persistence;

import com.devsu.account_service.infrastructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, String> {

	boolean existsByClientIdAndIsDeletedFalse(String clientId);

	Optional<CustomerEntity> findByClientIdAndIsDeletedFalse(String id);

}
