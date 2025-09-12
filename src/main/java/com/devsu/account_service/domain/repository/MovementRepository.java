package com.devsu.account_service.domain.repository;

import com.devsu.account_service.domain.models.Movement;
import com.devsu.account_service.domain.models.Report;
import com.devsu.account_service.domain.use_cases.movement.create.MovementCreateInput;

import java.time.LocalDateTime;
import java.util.Optional;

public interface MovementRepository {

	Movement create(MovementCreateInput createInput);

	Optional<Movement> findById(String movementId);

	Report.ClientReport getClientReport(String clientId, LocalDateTime from, LocalDateTime to);

}
