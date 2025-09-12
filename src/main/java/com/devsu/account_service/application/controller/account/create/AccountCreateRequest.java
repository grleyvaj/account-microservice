package com.devsu.account_service.application.controller.account.create;

import com.devsu.account_service.application.controller.validator.NumberNotUnique;
import com.devsu.account_service.domain.models.AccountType;
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
public class AccountCreateRequest {

	@JsonProperty("client_id")
	@Schema(description = "${account.clientId.description}", example = "01K4W1YEHEGR40R0E09GT8TYG6")
	@NotBlank(message = "account.clientId.notBlank")
	private String clientId;

	@JsonProperty("number")
	@Schema(description = "${account.number.description}", example = "ASDFEERT")
	@NotBlank(message = "account.number.notBlank")
	@Size(max = 255, message = "account.number.max")
	@NumberNotUnique(message = "account.number.notUnique")
	private String number;

	@JsonProperty("type")
	@Schema(description = "${account.type.description}", example = "SAVINGS")
	@NotNull(message = "account.type.null")
	private AccountType type;

	@JsonProperty("home_balance")
	@Schema(description = "${account.homeBalance.description}", example = "12345.12345")
	@NotNull(message = "account.homeBalance.null")
	@Digits(integer = 15, fraction = 5, message = "account.homeBalance.digits")
	private BigDecimal homeBalance;

	@JsonProperty("alias")
	@Schema(description = "${account.alias.description}", example = "Mis ahorros")
	@Size(max = 255, message = "account.alias.max")
	private String alias;
}
