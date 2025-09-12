package com.devsu.account_service.application.controller.movement.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class MovementSummaryDetailResponse {

	@JsonProperty("id")
	@Schema(description = "${movement.id.description}", example = "01K4SA5VMMYFDQM9C145SZGPW5")
	@NotBlank(message = "movement.id.notBlank")
	private String id;

	@JsonProperty("number")
	@Schema(description = "${account.number.description}", example = "ASDFEERT")
	@NotBlank(message = "account.number.notBlank")
	@Size(max = 255, message = "account.number.max")
	private String number;

	@JsonProperty("customer")
	@Schema(description = "${account.customer.description}", example = "Jose Lema")
	@NotBlank(message = "account.customer.notBlank")
	private String customer;

	@JsonProperty("execution_date")
	@Schema(description = "${movement.date.description}", example = "2025-09-11T18:30:00Z")
	@NotNull(message = "movement.date.notNull")
	private LocalDateTime executionDate;

	@JsonProperty("amount")
	@Schema(description = "${movement.amount.description}", example = "100.00000")
	@NotNull(message = "movement.amount.null")
	@Digits(integer = 15, fraction = 5, message = "movement.amount.digits")
	private BigDecimal amount;

	@JsonProperty("balance_before")
	@Schema(description = "${movement.balanceBefore.description}", example = "1000.12345")
	@NotNull(message = "movement.balanceBefore.null")
	@Digits(integer = 15, fraction = 5, message = "movement.balanceBefore.digits")
	private BigDecimal balanceBefore;

	@JsonProperty("after_before")
	@Schema(description = "${movement.afterBefore.description}", example = "900.12345")
	@NotNull(message = "movement.afterBefore.null")
	@Digits(integer = 15, fraction = 5, message = "movement.afterBefore.digits")
	private BigDecimal afterBefore;

}
