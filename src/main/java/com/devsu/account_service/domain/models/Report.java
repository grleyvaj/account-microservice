package com.devsu.account_service.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Report {

	public record ClientReport(
	  String clientId,
	  String name,
	  List<AccountReport> accounts
	) {}

	public record AccountReport(
	  String accountNumber,
	  String accountType,
	  BigDecimal initialBalance,
	  BigDecimal availableBalance,
	  List<MovementReport> movements
	) {}

	public record MovementReport(
	  LocalDateTime date,
	  String type,
	  BigDecimal beforeBalance,
	  BigDecimal amount,
	  BigDecimal afterBalance
	) {}

}
