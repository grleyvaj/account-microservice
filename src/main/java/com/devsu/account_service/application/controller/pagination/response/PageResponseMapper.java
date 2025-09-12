package com.devsu.account_service.application.controller.pagination.response;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.domain.pagination.Pagination;

public class PageResponseMapper implements Mapper<Pagination, PageResponse> {

	@Override
	public PageResponse map(Pagination input) {
		return new PageResponse(
		  input.getPage(),
		  input.getSize(),
		  input.getTotalElements(),
		  input.getTotalPages()
		);
	}

}
