package com.devsu.account_service.infrastructure.persistence;

import com.devsu.account_service.infrastructure.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountRepository extends JpaRepository<AccountEntity, String> {

	Optional<AccountEntity> findByIdAndIsDeletedFalse(String id);

	boolean existsByAccountNumberAndIsDeletedFalse(String accountNumber);

}
