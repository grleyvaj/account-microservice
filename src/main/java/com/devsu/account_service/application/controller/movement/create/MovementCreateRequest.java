package com.devsu.account_service.application.controller.movement.create;

import com.devsu.account_service.domain.models.MovementType;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class MovementCreateRequest {

	@JsonProperty("account_id")
	@Schema(description = "${movement.accountId.description}", example = "01K4W1YEHEGR40R0E09GT8TYG6")
	@NotBlank(message = "account.id.notBlank")
	private String accountId;

	@JsonProperty("execution_date")
	@Schema(description = "${movement.date.description}", example = "2025-09-11T18:30:00Z")
	@NotNull(message = "movement.date.notNull")
	private LocalDateTime executionDate;

	@JsonProperty("type")
	@Schema(description = "${movement.type.description}", example = "WITHDRAWAL")
	@NotNull(message = "movement.type.null")
	private MovementType type;

	@JsonProperty("amount")
	@Schema(description = "${movement.amount.description}", example = "12345.12345")
	@NotNull(message = "movement.amount.null")
	@Digits(integer = 15, fraction = 5, message = "movement.amount.digits")
	private BigDecimal amount;

}
