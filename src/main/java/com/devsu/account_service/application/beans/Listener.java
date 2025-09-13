package com.devsu.account_service.application.beans;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.application.listener.customer.CustomerEventListener;
import com.devsu.account_service.application.listener.customer.message.CustomerCreatedMessage;
import com.devsu.account_service.application.listener.customer.message.CustomerUpdatedMessage;
import com.devsu.account_service.domain.use_cases.customer.create.CustomerCreateInput;
import com.devsu.account_service.domain.use_cases.customer.create.CustomerCreateUseCase;
import com.devsu.account_service.domain.use_cases.customer.delete.CustomerDeleteUseCase;
import com.devsu.account_service.domain.use_cases.customer.update.CustomerUpdateInput;
import com.devsu.account_service.domain.use_cases.customer.update.CustomerUpdateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Listener {

	@Bean
	public CustomerEventListener customerEventListener(
	  CustomerCreateUseCase customerCreateUseCase,
	  CustomerUpdateUseCase customerUpdateUseCase,
	  CustomerDeleteUseCase customerDeleteUseCase,
	  Mapper<CustomerCreatedMessage, CustomerCreateInput> customerCreateInputMapper,
	  Mapper<CustomerUpdatedMessage, CustomerUpdateInput> customerUpdateInputMapper
	) {
		return new CustomerEventListener(
		  customerCreateUseCase,
		  customerUpdateUseCase,
		  customerDeleteUseCase,
		  customerCreateInputMapper,
		  customerUpdateInputMapper
		);
	}

}
