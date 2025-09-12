package com.devsu.account_service.application.controller.report;

import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.models.Report;
import com.devsu.account_service.domain.use_cases.report.ClientReportUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reports")
public class ReportsApiController implements ReportsApi {

	private final ClientReportUseCase clientReportUseCase;

	@Override
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Report.ClientReport> getAccountReport(
	  @RequestParam String client,
	  @RequestParam(value = "from_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
	  @RequestParam(value = "to_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate
	) throws ResourceNotFoundException {
		return ResponseEntity.ok(this.clientReportUseCase.execute(client, fromDate, toDate));
	}

}
