package com.devsu.account_service.domain.repository;

import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.models.Account;
import com.devsu.account_service.domain.models.AccountInfo;
import com.devsu.account_service.domain.use_cases.account.create.AccountCreateInput;
import com.devsu.account_service.domain.use_cases.account.update.AccountUpdateInput;

import java.util.Optional;

public interface AccountRepository {

	Account create(AccountCreateInput createInput) throws ResourceNotFoundException;

	boolean existsByNumber(String number);

	Optional<AccountInfo> findById(String accountId);

	AccountInfo update(String accountId, AccountUpdateInput accountUpdateInput) throws ResourceNotFoundException;

}
