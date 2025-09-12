package com.devsu.account_service.domain.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationException extends Exception {

	private final List<ValidationError> errors;

	public ValidationException(List<ValidationError> errors, String message) {
		super(message);
		this.errors = errors;
	}

	@Getter
	public static class ValidationError {
		private final String field;
		private final String code;

		public ValidationError(String field, String code) {
			this.field = field;
			this.code = code;
		}
	}

}
