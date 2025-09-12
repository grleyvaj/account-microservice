package com.devsu.account_service.domain.use_cases.movement.create;

import com.devsu.account_service.domain.models.MovementType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class MovementCreateInput {

	private final String accountId;
	private final LocalDateTime executionDate;
	private final MovementType type;
	private final BigDecimal amount;

	private String clientId;
	private BigDecimal balanceBefore;
	private BigDecimal balanceAfter;

	public MovementCreateInput addBalanceBefore(BigDecimal balanceBefore) {
		this.balanceBefore = balanceBefore;
		return this;
	}

	public MovementCreateInput addBalanceAfter(BigDecimal balanceAfter) {
		this.balanceAfter = balanceAfter;
		return this;
	}

	public MovementCreateInput addClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

	public boolean isCharge() {
		return type.equals(MovementType.WITHDRAWAL);
	}

	public BigDecimal signedAmount() {
		if(type == MovementType.WITHDRAWAL) {
			return amount.negate();
		}
		return amount;
	}

}
