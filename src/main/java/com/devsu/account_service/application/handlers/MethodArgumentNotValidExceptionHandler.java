package com.devsu.account_service.application.handlers;

import com.devsu.account_service.application.handlers.response.ValidationErrorResponse;
import com.devsu.account_service.application.handlers.response.ValidationErrorResponseCreator;
import com.devsu.account_service.application.handlers.response.ValidationErrorResponseList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static java.util.Objects.nonNull;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MethodArgumentNotValidExceptionHandler {

	private final ValidationErrorResponseCreator validationErrorResponseCreator;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ValidationErrorResponseList> handleMethodArgumentNotValidException(
	  final MethodArgumentNotValidException ex
	) {
		List<ValidationErrorResponse> errors = ex.getBindingResult().getFieldErrors()
		  .stream()
		  .filter(error -> nonNull(error.getDefaultMessage()))
		  .map(error ->
			this.validationErrorResponseCreator
			  .create(error.getDefaultMessage())
			  .setField(error.getField())
		  )
		  .toList();

		return ResponseEntity
		  .status(HttpStatus.BAD_REQUEST)
		  .body(new ValidationErrorResponseList(errors));
	}

}
