package com.devsu.account_service.application.controller.account.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AccountListResponse {

	@JsonProperty("accounts")
	private final List<AccountSummaryResponse> accounts;

}
