package com.devsu.account_service.application.controller.account.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class AccountSummaryResponse {

	@JsonProperty("number")
	@Schema(description = "${account.number.description}", example = "ASDFEERT")
	@NotBlank(message = "account.number.notBlank")
	@Size(max = 255, message = "account.number.max")
	private String number;

	@JsonProperty("type")
	@Schema(description = "${account.type.description}", example = "SAVINGS")
	@NotNull(message = "account.type.null")
	private String type;

	@JsonProperty("home_balance")
	@Schema(description = "${account.homeBalance.description}", example = "12345.12345")
	@NotNull(message = "account.homeBalance.null")
	@Digits(integer = 15, fraction = 5, message = "account.homeBalance.digits")
	private BigDecimal homeBalance;

	@JsonProperty("available_balance")
	@Schema(description = "${account.availableBalance.description}", example = "12345.12345")
	@NotNull(message = "account.availableBalance.null")
	@Digits(integer = 15, fraction = 5, message = "account.homeBalance.digits")
	private BigDecimal availableBalance;

	@JsonProperty("alias")
	@Schema(description = "${account.alias.description}", example = "Mis ahorros")
	@Size(max = 255, message = "account.alias.max")
	private String alias;

}
