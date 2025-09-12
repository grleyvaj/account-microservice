package com.devsu.account_service.application.controller.movement.detail;

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
public class MovementDetailResponse {

	@JsonProperty("id")
	@Schema(description = "${movement.id.description}", example = "01K4SA5VMMYFDQM9C145SZGPW5")
	@NotBlank(message = "movement.id.notBlank")
	private String id;

	@JsonProperty("number")
	@Schema(description = "${movement.motion.description}", example = "Withdrawal of 500.000")
	@NotBlank(message = "movement.motion.notBlank")
	private String motion;

	@JsonProperty("balance_before")
	@Schema(description = "${movement.balanceBefore.description}", example = "1000.00000")
	@NotNull(message = "movement.balanceBefore.null")
	@Digits(integer = 15, fraction = 5, message = "movement.balanceBefore.digits")
	private BigDecimal balanceBefore;

	@JsonProperty("amount")
	@Schema(description = "${movement.amount.description}", example = "500.00000")
	@NotNull(message = "movement.amount.null")
	@Digits(integer = 15, fraction = 5, message = "movement.amount.digits")
	private BigDecimal amount;

	@JsonProperty("after_before")
	@Schema(description = "${movement.balanceAfter.description}", example = "500.00000")
	@NotNull(message = "movement.balanceAfter.null")
	@Digits(integer = 15, fraction = 5, message = "movement.balanceAfter.digits")
	private BigDecimal balanceAfter;

	@JsonProperty("execution_date")
	@Schema(description = "${movement.date.description}", example = "2025-09-11T18:30:00Z")
	@NotNull(message = "movement.date.notNull")
	private LocalDateTime executionDate;

}
