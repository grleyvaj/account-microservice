package com.devsu.account_service.application.contract;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListMapper<From, To> {

	private final Mapper<From, To> mapper;

	public List<To> map(List<From> input) {
		return input.stream()
		  .map(this.mapper::map)
		  .toList();
	}

}