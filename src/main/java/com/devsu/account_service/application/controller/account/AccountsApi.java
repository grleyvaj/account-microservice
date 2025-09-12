package com.devsu.account_service.application.controller.account;

import com.devsu.account_service.application.controller.account.create.AccountCreateRequest;
import com.devsu.account_service.application.controller.account.detail.AccountDetailResponse;
import com.devsu.account_service.application.controller.account.list.AccountListResponse;
import com.devsu.account_service.application.controller.account.update.AccountUpdateRequest;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "${api.tag.accounts.name}", description = "${api.tag.accounts.description}")
public interface AccountsApi {

	@Operation(
	  summary = "${api.account.create.summary}",
	  description = "${api.account.create.description}",
	  operationId = "createAccount"
	)
	@ApiResponses({
	  @ApiResponse(responseCode = "201", description = "${api.account.create.response.201.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AccountDetailResponse.class))),
	  @ApiResponse(responseCode = "400", description = "${api.response.400.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationErrorResponseList.class))),
	  @ApiResponse(responseCode = "401", description = "${api.response.401.description}", content = @Content),
	  @ApiResponse(responseCode = "403", description = "${api.response.403.description}", content = @Content),
	  @ApiResponse(responseCode = "404", description = "${api.response.404.description}",
		content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
	  @ApiResponse(responseCode = "500", description = "${api.response.500.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
	})
	ResponseEntity<AccountDetailResponse> create(
	  @RequestBody(required = true) @Valid AccountCreateRequest request
	) throws ValidationException, ResourceNotFoundException;

	@Operation(
	  summary = "${api.account.detail.summary}",
	  description = "${api.account.detail.description}",
	  operationId = "getDetailAccount"
	)
	@ApiResponses({
	  @ApiResponse(responseCode = "200", description = "${api.account.detail.response.200.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AccountDetailResponse.class))),
	  @ApiResponse(responseCode = "401", description = "${api.response.401.description}", content = @Content),
	  @ApiResponse(responseCode = "403", description = "${api.response.403.description}", content = @Content),
	  @ApiResponse(responseCode = "404", description = "${api.response.404.description}",
		content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
	  @ApiResponse(responseCode = "500", description = "${api.response.500.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
	})
	ResponseEntity<AccountDetailResponse> detail(
	  @Parameter(
		in = ParameterIn.PATH,
		name = "id",
		description = "${account.id.description}",
		required = true,
		schema = @Schema(type = "string", format = "ulid", example = "01HZX0SYT8P7TQ2J0GKH2HF26R")
	  ) String id
	) throws ResourceNotFoundException;

	@Operation(
	  summary = "${api.account.update.summary}",
	  description = "${api.account.update.description}",
	  operationId = "updateAccount"
	)
	@ApiResponses({
	  @ApiResponse(responseCode = "200", description = "${api.account.update.response.200.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AccountDetailResponse.class))),
	  @ApiResponse(responseCode = "400", description = "${api.response.400.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ValidationErrorResponseList.class))),
	  @ApiResponse(responseCode = "401", description = "${api.response.401.description}", content = @Content),
	  @ApiResponse(responseCode = "403", description = "${api.response.403.description}", content = @Content),
	  @ApiResponse(responseCode = "404", description = "${api.response.404.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
	  @ApiResponse(responseCode = "500", description = "${api.response.500.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
	})
	ResponseEntity<AccountDetailResponse> update(
	  @Parameter(
		in = ParameterIn.PATH,
		name = "id",
		description = "${account.id.description}",
		required = true,
		schema = @Schema(type = "string", format = "ulid", example = "01HZX0SYT8P7TQ2J0GKH2HF26R")
	  ) String id,
	  @RequestBody(required = true) @Valid AccountUpdateRequest request
	) throws ResourceNotFoundException, ValidationException;

	@Operation(
	  summary = "${api.account.actives.summary}",
	  description = "${api.account.actives.description}",
	  operationId = "getActives"
	)
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "${api.account.actives.response.200.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AccountListResponse.class))),
	  @ApiResponse(responseCode = "401", description = "${api.response.401.description}", content = @Content),
	  @ApiResponse(responseCode = "403", description = "${api.response.403.description}", content = @Content),
	  @ApiResponse(responseCode = "500", description = "${api.response.500.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
	})
	ResponseEntity<AccountListResponse> getActives(
	  @Parameter(
		in = ParameterIn.PATH,
		name = "client",
		description = "${client.id.description}",
		required = true,
		schema = @Schema(type = "string", format = "ulid", example = "01HZX0SYT8P7TQ2J0GKH2HF26R")
	  ) String client
	);

}
