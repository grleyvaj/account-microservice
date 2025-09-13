package com.devsu.account_service.application.listener.customer.message;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.use_cases.customer.create.CustomerCreateInput;

public class CustomerCreatedInputMapper implements Mapper<CustomerCreatedMessage, CustomerCreateInput> {

	@Override
	public CustomerCreateInput map(CustomerCreatedMessage input) {
		return new CustomerCreateInput(
		  input.getClientId(),
		  input.getName(),
		  input.getCreatedAt()
		);
	}

}
