package com.devsu.account_service.infrastructure.persistence;

import com.devsu.account_service.infrastructure.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovementRepository extends JpaRepository<MovementEntity, String> {

}
