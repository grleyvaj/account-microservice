package com.devsu.account_service.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ValueDeserializationException extends RuntimeException {

	public ValueDeserializationException(String message) {
		super(message);
	}

}
