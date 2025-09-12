package com.devsu.account_service.application.controller.movement.detail;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.models.Movement;

public class MovementDetailResponseMapper implements Mapper<Movement, MovementDetailResponse> {

	@Override
	public MovementDetailResponse map(Movement movement) {
		return new MovementDetailResponse()
		  .setId(movement.getId())
		  .setMotion(movement.getDescription())
		  .setBalanceBefore(movement.getBalanceBefore())
		  .setAmount(movement.getAmount())
		  .setBalanceAfter(movement.getBalanceAfter())
		  .setExecutionDate(movement.getExecutionDate());
	}

}
