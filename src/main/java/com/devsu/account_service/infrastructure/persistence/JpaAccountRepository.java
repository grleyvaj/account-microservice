package com.devsu.account_service.infrastructure.persistence;

import com.devsu.account_service.infrastructure.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface JpaAccountRepository extends JpaRepository<AccountEntity, String> {

	Optional<AccountEntity> findByIdAndIsDeletedFalse(String id);

	Optional<AccountEntity> findByIdAndIsActiveTrueAndIsDeletedFalse(String id);

	List<AccountEntity> findByClientIdAndIsActiveTrueAndIsDeletedFalse(String clientId);

	boolean existsByAccountNumberAndIsDeletedFalse(String accountNumber);

	@Modifying
	@Query("UPDATE AccountEntity a " +
	       "SET a.availableBalance = :availableBalance, " +
	       "    a.updatedAt = :updatedAt " +
	       "WHERE a.id = :id AND a.isDeleted = false")
	void updateAvailableBalance(
	  @Param("id") String id,
	  @Param("availableBalance") BigDecimal availableBalance,
	  @Param("updatedAt") LocalDateTime updatedAt
	);

}
