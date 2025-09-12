package com.devsu.account_service.application.controller.report;

import com.devsu.account_service.application.handlers.response.ErrorResponse;
import com.devsu.account_service.domain.exception.ResourceNotFoundException;
import com.devsu.account_service.domain.models.Report;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "${api.tag.reports.name}", description = "${api.tag.reports.description}")
public interface ReportsApi {

	@Operation(
	  summary = "${api.account.report.summary}",
	  description = "${api.account.report.description}",
	  operationId = "getAccountReport"
	)
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "${api.account.report.200.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Report.ClientReport.class))),
	  @ApiResponse(responseCode = "401", description = "${api.response.401.description}", content = @Content),
	  @ApiResponse(responseCode = "403", description = "${api.response.403.description}", content = @Content),
	  @ApiResponse(responseCode = "500", description = "${api.response.500.description}",
		content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
	})
	ResponseEntity<Report.ClientReport> getAccountReport(
	  @Parameter(
		in = ParameterIn.QUERY,
		name = "client",
		required = true,
		description = "${customer.id.description}",
		example = "01K4W28848S15638N34TT76CPT",
		schema = @Schema(type = "string", format = "ulid", example = "01K4W28848S15638N34TT76CPT")
	  ) String client,
	  @Parameter(in = ParameterIn.QUERY, name = "fromDate", description = "${api.op.paginatedList.parameter.fromDate.description}", example = "2025-04-01T10:15:30")
	  @RequestParam(value = "from_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
	  @Parameter(in = ParameterIn.QUERY, name = "toDate", description = "${api.op.paginatedList.parameter.toDate.description}", example = "2025-04-30T10:15:30")
	  @RequestParam(value = "to_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate
	) throws ResourceNotFoundException;

}
