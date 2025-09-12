package com.devsu.account_service.application.controller.validator;

import com.devsu.account_service.domain.repository.AccountRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
public class NumberNotUniqueValidator implements ConstraintValidator<NumberNotUnique, String> {

	private final AccountRepository accountRepository;

	@Override
	public boolean isValid(String number, ConstraintValidatorContext context) {
		if(isNull(number)) {
			return true;
		}
		return !this.accountRepository.existsByNumber(number);
	}

}