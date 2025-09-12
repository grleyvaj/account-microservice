package com.devsu.account_service.application.contract;

public interface Mapper<T, F> {

	F map(T input);
}
