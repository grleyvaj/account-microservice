package com.devsu.account_service.domain.use_cases.movement.detail;

import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.models.Movement;
import com.devsu.account_service.domain.repository.MovementRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovementDetailUseCase {

	private final MovementRepository movementRepository;

	public Movement execute(String movementId) throws ResourceNotFoundException {
		return this.movementRepository.findById(movementId).orElseThrow(
		  () -> new ResourceNotFoundException("Movement %s not found".formatted(movementId))
		);
	}

}
