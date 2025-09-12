package com.devsu.account_service.domain.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Customer {

	private final String clientId;
	private final String name;

}
