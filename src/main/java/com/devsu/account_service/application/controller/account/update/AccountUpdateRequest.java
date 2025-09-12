package com.devsu.account_service.application.controller.account.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AccountUpdateRequest {

	@JsonProperty("alias")
	@Schema(description = "${account.alias.description}", example = "Mis ahorros")
	@Size(max = 255, message = "account.alias.max")
	private String alias;

	@JsonProperty("state")
	@Schema(description = "${account.state.description}", example = "True")
	private Boolean state;

}
