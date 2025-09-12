package com.devsu.account_service.infrastructure.entity;

import com.devsu.account_service.domain.models.AccountType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "accounts")
public class AccountEntity extends AuditableEntity {

	@Id
	@Column(length = 26)
	private String id;

	@Column(name = "account_number", length = 255, nullable = false)
	private String accountNumber;

	@Column(name = "account_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private AccountType type;

	@Column(name = "home_balance", precision = 20, scale = 5, nullable = false)
	private BigDecimal homeBalance;

	@Column(name = "available_balance", precision = 20, scale = 5, nullable = false)
	private BigDecimal availableBalance;

	@Version
	@Column(name = "version")
	private Long version;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@Column(name = "alias", length = 255)
	private String alias;

	@Column(name = "client_id", nullable = false)
	private String clientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", referencedColumnName = "client_id", insertable = false, updatable = false)
	private CustomerEntity customer;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", updatable = false)
	private CustomerEntity customer;*/

	@Column(name = "is_deleted")
	private Boolean isDeleted = false;

}