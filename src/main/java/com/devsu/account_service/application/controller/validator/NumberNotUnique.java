package com.devsu.account_service.application.controller.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NumberNotUniqueValidator.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberNotUnique {

	String message() default "Account number already exist"; // Mensaje predeterminado

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
