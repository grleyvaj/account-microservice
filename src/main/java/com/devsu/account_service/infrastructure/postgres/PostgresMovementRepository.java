package com.devsu.account_service.infrastructure.postgres;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.models.Movement;
import com.devsu.account_service.domain.models.Report;
import com.devsu.account_service.domain.repository.MovementRepository;
import com.devsu.account_service.domain.use_cases.movement.create.MovementCreateInput;
import com.devsu.account_service.infrastructure.entity.AccountEntity;
import com.devsu.account_service.infrastructure.entity.CustomerEntity;
import com.devsu.account_service.infrastructure.entity.MovementEntity;
import com.devsu.account_service.infrastructure.persistence.JpaMovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PostgresMovementRepository implements MovementRepository {

	private final JpaMovementRepository jpaMovementRepository;
	private final Mapper<MovementCreateInput, MovementEntity> movementEntityMapper;
	private final Mapper<MovementEntity, Movement> movementMapper;

	@Override
	public Movement create(MovementCreateInput createInput) {
		return this.movementMapper.map(
		  this.jpaMovementRepository.save(
			this.movementEntityMapper.map(createInput)
		  )
		);
	}

	@Override
	public Optional<Movement> findById(String movementId) {
		return this.jpaMovementRepository.findByIdAndIsDeletedFalse(movementId)
		  .map(this.movementMapper::map);
	}

	@Override
	@Transactional(readOnly = true)
	public Report.ClientReport getClientReport(String clientId, LocalDateTime from, LocalDateTime to) {

		Specification<MovementEntity> spec = MovementSpecs.byClientAndDateRange(clientId, from, to);
		Sort sort = Sort.by(Sort.Order.asc("id"));

		List<MovementEntity> movements = this.jpaMovementRepository.findAll(spec, sort);

		if(movements.isEmpty()) {
			return new Report.ClientReport(clientId, null, List.of());
		}

		// Recuperar el nombre del cliente desde la primera fila (porque el spec asegura join)
		String clientName = Optional.ofNullable(movements.getFirst().getAccount())
		  .map(AccountEntity::getCustomer)
		  .map(CustomerEntity::getName)
		  .orElse(null);

		// Agrupar movimientos por cuenta
		Map<String, List<MovementEntity>> byAccount = movements.stream()
		  .collect(
			Collectors.groupingBy(
			  m -> m.getAccount().getAccountNumber(),
			  LinkedHashMap::new,
			  Collectors.toList()
			));

		List<Report.AccountReport> accounts = byAccount.entrySet().stream().map(entry -> {
			String accountNumber = entry.getKey();
			List<MovementEntity> movs = entry.getValue();

			AccountEntity accountEntity = movs.getFirst().getAccount();

			List<Report.MovementReport> movementReports = movs
			  .stream()
			  .map(movement -> new Report.MovementReport(
				movement.getExecutionDate(),
				movement.getMovementType().name(),
				movement.getBalanceBefore(),
				movement.getAmount(),
				movement.getBalanceAfter()
			  )).toList();

			return new Report.AccountReport(
			  accountNumber,
			  accountEntity.getType().name(),
			  accountEntity.getHomeBalance(),
			  accountEntity.getAvailableBalance(),
			  movementReports
			);
		}).toList();

		return new Report.ClientReport(clientId, clientName, accounts);
	}

}
