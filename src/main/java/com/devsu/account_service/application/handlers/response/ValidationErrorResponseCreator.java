package com.devsu.account_service.application.handlers.response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

@RequiredArgsConstructor
@Slf4j
public class ValidationErrorResponseCreator {

	private final MessageSource messageSource;

	public ValidationErrorResponse create(String code) {
		try {
			String msg = this.messageSource.getMessage(code.concat(".detail"), null, Locale.getDefault());
			log.error(msg);
			return new ValidationErrorResponse(
			  code,
			  this.messageSource.getMessage(code, null, Locale.getDefault()),
			  msg
			);
		} catch(NoSuchMessageException ex) {
			log.error("No message found for code: {}", code, ex);
			return new ValidationErrorResponse(
			  code,
			  "Unknown error",
			  "No detailed message available"
			);
		}
	}

}