package com.devsu.account_service.application.controller.movement;

import com.devsu.account_service.application.controller.movement.create.MovementCreateRequest;
import com.devsu.account_service.application.controller.movement.detail.MovementDetailResponse;
import com.devsu.account_service.application.handlers.response.ErrorResponse;
import com.devsu.account_service.application.handlers.response.ValidationErrorResponseList;
import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.exception.ValidationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "${api.tag.movements.name}", description = "${api.tag.movements.description}")
public interface MovementsApi {

	@Operation(
	  summary = "${api.movement.create.summary}",
	  description = "${api.movement.create.description}",
	  operationId = "createMovement"
	)
	@ApiResponses({
	  @ApiResponse(responseCode = "201", description = "${api.movement.create.response.201.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = MovementDetailResponse.class))),
	  @ApiResponse(responseCode = "400", description = "${api.response.400.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationErrorResponseList.class))),
	  @ApiResponse(responseCode = "401", description = "${api.response.401.description}", content = @Content),
	  @ApiResponse(responseCode = "403", description = "${api.response.403.description}", content = @Content),
	  @ApiResponse(responseCode = "404", description = "${api.response.404.description}",
		content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
	  @ApiResponse(responseCode = "500", description = "${api.response.500.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
	})
	ResponseEntity<MovementDetailResponse> create(
	  @RequestBody(required = true) @Valid MovementCreateRequest request
	) throws ValidationException, ResourceNotFoundException;

	@Operation(
	  summary = "${api.movement.detail.summary}",
	  description = "${api.movement.detail.description}",
	  operationId = "getDetailMovement"
	)
	@ApiResponses({
	  @ApiResponse(responseCode = "200", description = "${api.movement.detail.response.200.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = MovementDetailResponse.class))),
	  @ApiResponse(responseCode = "401", description = "${api.response.401.description}", content = @Content),
	  @ApiResponse(responseCode = "403", description = "${api.response.403.description}", content = @Content),
	  @ApiResponse(responseCode = "404", description = "${api.response.404.description}",
		content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
	  @ApiResponse(responseCode = "500", description = "${api.response.500.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
	})
	ResponseEntity<MovementDetailResponse> detail(
	  @Parameter(
		in = ParameterIn.PATH,
		name = "id",
		description = "${movement.id.description}",
		required = true,
		schema = @Schema(type = "string", format = "ulid", example = "01HZX0SYT8P7TQ2J0GKH2HF26R")
	  ) String id
	) throws ResourceNotFoundException;

}
