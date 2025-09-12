package com.devsu.account_service.application.handlers;

import com.devsu.account_service.application.handlers.response.ValidationErrorResponseCreator;
import com.devsu.account_service.application.handlers.response.ValidationErrorResponseList;
import com.devsu.account_service.domain.exception.ValidationException;
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
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class ValidationExceptionHandler {

	private final ValidationErrorResponseCreator validationErrorResponseCreator;

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ValidationErrorResponseList> handleValidationException(ValidationException ex) {
		log.debug(ex.getMessage(), ex);

		return new ResponseEntity<>(
		  new ValidationErrorResponseList(
			ex.getErrors()
			  .stream()
			  .map(error -> this.validationErrorResponseCreator
				.create(error.getCode())
				.setField(error.getField()))
			  .toList()
		  ),
		  HttpStatus.BAD_REQUEST
		);
	}

}