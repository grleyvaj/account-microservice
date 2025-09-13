package com.devsu.account_service.application.listener.customer.message;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.use_cases.customer.update.CustomerUpdateInput;

public class CustomerUpdatedInputMapper implements Mapper<CustomerUpdatedMessage, CustomerUpdateInput> {

	@Override
	public CustomerUpdateInput map(CustomerUpdatedMessage input) {
		return new CustomerUpdateInput(
		  input.getClientId(),
		  input.getName(),
		  input.getCreatedAt(),
		  input.getUpdatedAt()
		);
	}

}
