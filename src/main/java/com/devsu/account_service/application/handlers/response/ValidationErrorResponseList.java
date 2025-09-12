package com.devsu.account_service.application.handlers.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ValidationErrorResponseList {

	@JsonProperty("errors")
	private final List<ValidationErrorResponse> errors;

}