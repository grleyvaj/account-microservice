package com.devsu.account_service.infrastructure.entity;

import com.devsu.account_service.domain.models.MovementType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "movements")
public class MovementEntity extends AuditableEntity {

	@Id
	@Column(length = 26)
	private String id;

	@Column(name = "execution_date", nullable = false)
	private LocalDateTime executionDate;

	@Column(name = "movement_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private MovementType movementType;

	@Column(name = "amount", precision = 20, scale = 5, nullable = false)
	private BigDecimal amount;

	@Column(name = "balance_before", precision = 20, scale = 5, nullable = false)
	private BigDecimal balanceBefore;

	@Column(name = "balance_after", precision = 20, scale = 5, nullable = false)
	private BigDecimal balanceAfter;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@Column(name = "account_id", nullable = false)
	private String accountId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", referencedColumnName = "client_id", insertable = false, updatable = false)
	private AccountEntity account;

	@Column(name = "is_deleted")
	private Boolean isDeleted = false;

}