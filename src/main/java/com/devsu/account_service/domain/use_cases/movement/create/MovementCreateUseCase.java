package com.devsu.account_service.domain.use_cases.movement.create;

import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.exception.ValidationException;
import com.devsu.account_service.domain.models.Account;
import com.devsu.account_service.domain.models.Movement;
import com.devsu.account_service.domain.repository.AccountRepository;
import com.devsu.account_service.domain.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class MovementCreateUseCase {

	private final AccountRepository accountRepository;
	private final MovementRepository movementRepository;

	@Transactional
	public Movement execute(MovementCreateInput createInput) throws ResourceNotFoundException, ValidationException {
		Account account = this.accountRepository.findActiveById(createInput.getAccountId())
		  .orElseThrow(() -> new ResourceNotFoundException("Account %s not found".formatted(createInput.getAccountId())));

		if(createInput.isCharge()
		   && account.getAvailableBalance().compareTo(createInput.getAmount()) < 0
		) {
			throw new ValidationException(
			  List.of(new ValidationException.ValidationError("account_id", "account.balance.notAvailable")),
			  "Balance not available"
			);
		}

		BigDecimal beforeBalance = account.getAvailableBalance();
		BigDecimal availableBalance = account.getAvailableBalance().add(createInput.signedAmount());

		createInput
		  .addBalanceBefore(beforeBalance)
		  .addBalanceAfter(availableBalance)
		  .addClientId(account.getClientId());

		this.accountRepository.updateAvailableBalance(createInput.getAccountId(), availableBalance);
		return this.movementRepository.create(createInput);
	}

}
