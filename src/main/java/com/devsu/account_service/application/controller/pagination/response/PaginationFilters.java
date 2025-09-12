package com.devsu.account_service.application.controller.pagination.response;

import com.devsu.account_service.domain.models.SortDirection;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PaginationFilters {

	private int page;
	private int size;
	private SortDirection sort;

}
