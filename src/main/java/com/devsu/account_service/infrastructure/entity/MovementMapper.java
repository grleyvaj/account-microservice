package com.devsu.account_service.infrastructure.entity;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.models.Account;
import com.devsu.account_service.domain.models.Movement;

public class MovementMapper implements Mapper<MovementEntity, Movement> {

	@Override
	public Movement map(MovementEntity movementEntity) {

		return new Movement(
		  movementEntity.getId(),
		  movementEntity.getMovementType(),
		  movementEntity.getExecutionDate(),
		  movementEntity.getAmount(),
		  movementEntity.getBalanceBefore(),
		  movementEntity.getBalanceAfter(),
		  movementEntity.getIsActive()
		);
	}

}
