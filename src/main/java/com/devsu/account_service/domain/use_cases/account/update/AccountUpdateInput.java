package com.devsu.account_service.domain.use_cases.account.update;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@Accessors(chain = true)
public class AccountUpdateInput {

	private Boolean state;
	private String alias;

	public Optional<Boolean> getState() {
		return Optional.ofNullable(state);
	}

	public Optional<String> getAlias() {
		return Optional.ofNullable(alias);
	}

}
