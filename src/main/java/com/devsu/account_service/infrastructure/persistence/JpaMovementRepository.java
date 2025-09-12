package com.devsu.account_service.infrastructure.persistence;

import com.devsu.account_service.infrastructure.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface JpaMovementRepository extends JpaRepository<MovementEntity, String>, JpaSpecificationExecutor<MovementEntity> {

	Optional<MovementEntity> findByIdAndIsDeletedFalse(String id);

}
