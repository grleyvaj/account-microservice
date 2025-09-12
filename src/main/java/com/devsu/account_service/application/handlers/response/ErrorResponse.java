package com.devsu.account_service.application.handlers.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class ErrorResponse {

	@Schema(name = "message", description = "${error.response.message.description}", example = "Resource not found")
	private String message;

}
