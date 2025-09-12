package com.devsu.account_service.infrastructure.entity;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.helpers.Generator;
import com.devsu.account_service.domain.use_cases.movement.create.MovementCreateInput;

import java.time.LocalDateTime;

public class MovementEntityMapper implements Mapper<MovementCreateInput, MovementEntity> {

	@Override
	public MovementEntity map(MovementCreateInput createInput) {
		LocalDateTime current = LocalDateTime.now();

		return (MovementEntity)new MovementEntity()
		  .setId(Generator.ulid())
		  .setAccountId(createInput.getAccountId())
		  .setExecutionDate(createInput.getExecutionDate())
		  .setMovementType(createInput.getType())
		  .setAmount(createInput.getAmount())
		  .setBalanceBefore(createInput.getBalanceBefore())
		  .setBalanceAfter(createInput.getBalanceAfter())
		  .setIsActive(Boolean.TRUE)
		  .setCreatedAt(current)
		  .setUpdatedAt(current);
	}

}
