package com.devsu.account_service.infrastructure.postgres;

import com.devsu.account_service.infrastructure.entity.AccountEntity;
import com.devsu.account_service.infrastructure.entity.CustomerEntity;
import com.devsu.account_service.infrastructure.entity.MovementEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.Objects;

public class MovementSpecs {

	public static Specification<MovementEntity> byClientAndDateRange(
	  String clientId,
	  LocalDateTime from,
	  LocalDateTime to
	) {
		return (root, query, cb) -> {
			// Evitar duplicados al hacer joins en paginaciones
			root.fetch("account", JoinType.LEFT);

			Join<MovementEntity, AccountEntity> accountJoin = root.join("account", JoinType.INNER);
			Join<AccountEntity, CustomerEntity> customerJoin = accountJoin.join("customer", JoinType.INNER);

			var predicates = cb.conjunction();

			predicates = cb.and(predicates, cb.isFalse(root.get("isDeleted")));
			predicates = cb.and(predicates, cb.isFalse(accountJoin.get("isDeleted")));
			predicates = cb.and(predicates, cb.isFalse(customerJoin.get("isDeleted")));

			if (Objects.nonNull(clientId) && !clientId.isBlank()) {
				predicates = cb.and(predicates, cb.equal(accountJoin.get("clientId"), clientId));
			}

			if (Objects.nonNull(from)) {
				predicates = cb.and(predicates, cb.greaterThanOrEqualTo(root.get("executionDate"), from));
			}

			if (Objects.nonNull(to)) {
				predicates = cb.and(predicates, cb.lessThanOrEqualTo(root.get("executionDate"), to));
			}

			return predicates;
		};
	}

}
