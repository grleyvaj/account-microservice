package com.devsu.account_service.application.controller.movement;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.application.controller.movement.create.MovementCreateRequest;
import com.devsu.account_service.application.controller.movement.detail.MovementDetailResponse;
import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.exception.ValidationException;
import com.devsu.account_service.domain.models.Movement;
import com.devsu.account_service.domain.use_cases.movement.create.MovementCreateInput;
import com.devsu.account_service.domain.use_cases.movement.create.MovementCreateUseCase;
import com.devsu.account_service.domain.use_cases.movement.detail.MovementDetailUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movements")
public class MovementsApiController implements MovementsApi {

	private final MovementCreateUseCase movementCreateUseCase;
	private final MovementDetailUseCase movementDetailUseCase;
	private final Mapper<MovementCreateRequest, MovementCreateInput> movementCreateInputMapper;
	private final Mapper<Movement, MovementDetailResponse> movementDetailResponseMapper;

	@Override
	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<MovementDetailResponse> create(
	  @RequestBody @Valid MovementCreateRequest request
	) throws ValidationException, ResourceNotFoundException {

		Movement movement = this.movementCreateUseCase.execute(
		  this.movementCreateInputMapper.map(request)
		);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
		  .path("/{id}")
		  .buildAndExpand(movement.getId())
		  .toUri();

		return ResponseEntity.created(uri).body(this.movementDetailResponseMapper.map(movement));
	}

	@Override
	@GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<MovementDetailResponse> detail(
	  @PathVariable(value = "id") String id
	) throws ResourceNotFoundException {
		return ResponseEntity.ok(
		  this.movementDetailResponseMapper.map(
			this.movementDetailUseCase.execute(id)
		  )
		);
	}

}
