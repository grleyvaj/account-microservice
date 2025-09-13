package com.devsu.account_service.application.configuration.documentation;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class ValidationMessageProperties {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasename("classpath:i18n/validation_message");
		ms.setDefaultEncoding("UTF-8");
		ms.setDefaultLocale(Locale.ENGLISH);
		return ms;
	}

}