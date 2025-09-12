package com.devsu.account_service.application.beans;

import com.devsu.account_service.application.handlers.response.ValidationErrorResponseCreator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Validators {

	@Bean
	public ValidationErrorResponseCreator validationErrorResponseCreator(MessageSource messageSource) {
		return new ValidationErrorResponseCreator(messageSource);
	}
//
//	@Bean
//	public CustomerDeserializer customerDeserializer(CustomerRepository customerRepository) {
//		return new CustomerDeserializer(customerRepository);
//	}

}
