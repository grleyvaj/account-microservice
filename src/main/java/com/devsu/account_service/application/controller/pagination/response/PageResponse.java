package com.devsu.account_service.application.controller.pagination.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PageResponse {

	@Schema(description = "${page.response.number.description}", example = "0")
	@JsonProperty("number")
	private final Integer number;

	@Schema(description = "${page.response.size.description}", example = "10")
	@JsonProperty("size")
	private final Integer size;

	@Schema(description = "${page.response.totalElements.description}", example = "50")
	@JsonProperty("totalElements")
	private final Long totalElements;

	@Schema(description = "${page.response.totalPages.description}", example = "5")
	@JsonProperty("totalPages")
	private final Integer totalPages;

}