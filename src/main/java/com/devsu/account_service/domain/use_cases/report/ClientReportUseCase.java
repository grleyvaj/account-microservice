package com.devsu.account_service.domain.use_cases.report;

import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.models.Customer;
import com.devsu.account_service.domain.models.Report;
import com.devsu.account_service.domain.repository.CustomerRepository;
import com.devsu.account_service.domain.repository.MovementRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
public class ClientReportUseCase {

	private final CustomerRepository customerRepository;
	private final MovementRepository movementRepository;

	public Report.ClientReport execute(
	  String clientId,
	  LocalDateTime fromDate,
	  LocalDateTime toDate
	  ) throws ResourceNotFoundException {
		Optional<Customer> customer = this.customerRepository.findByClientId(clientId);

		if(customer.isEmpty()) {
			return new Report.ClientReport(clientId, null, new ArrayList<>());
		}
		else {
			return this.movementRepository.getClientReport(clientId, fromDate, toDate);
		}
	}

}
