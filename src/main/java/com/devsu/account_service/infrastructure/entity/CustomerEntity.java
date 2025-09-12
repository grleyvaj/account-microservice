package com.devsu.account_service.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "customers")
public class CustomerEntity extends AuditableEntity {

	@Id
	@Column(name = "client_id", nullable = false)
	private String clientId;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "is_deleted")
	private Boolean isDeleted = false;

}

