package com.devsu.account_service.domain.pagination;

import lombok.Data;

@Data
public class Pagination {

	private final int page;
	private final int size;
	private final long totalElements;
	private final int totalPages;
	private final boolean isLast;

}
