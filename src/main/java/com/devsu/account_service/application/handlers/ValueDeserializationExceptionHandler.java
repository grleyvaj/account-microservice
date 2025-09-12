package com.devsu.account_service.application.handlers;

import com.devsu.account_service.application.handlers.response.ErrorResponse;
import com.devsu.account_service.application.handlers.response.ValidationErrorResponseCreator;
import com.devsu.account_service.domain.exception.ValueDeserializationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ValueDeserializationExceptionHandler {

	private final ValidationErrorResponseCreator validationErrorResponseCreator;

	@ExceptionHandler(ValueDeserializationException.class)
	protected ResponseEntity<ErrorResponse> handleValueDeserializationException(
	  final ValueDeserializationException ex
	) {
		ErrorResponse errorResponse = new ErrorResponse().setMessage(ex.getMessage());

		log.error(ex.getMessage(), ex);

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
