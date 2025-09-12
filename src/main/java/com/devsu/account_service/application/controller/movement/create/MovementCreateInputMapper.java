package com.devsu.account_service.application.controller.movement.create;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.use_cases.movement.create.MovementCreateInput;

public class MovementCreateInputMapper implements Mapper<MovementCreateRequest, MovementCreateInput> {

	@Override
	public MovementCreateInput map(MovementCreateRequest request) {
		return new MovementCreateInput(
		  request.getAccountId(),
		  request.getExecutionDate(),
		  request.getType(),
		  request.getAmount()
		);
	}

}
