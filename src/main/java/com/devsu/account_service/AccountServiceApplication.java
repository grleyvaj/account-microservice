package com.devsu.account_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
  scanBasePackages = {
	"com.devsu.account_service.application.beans",
	"com.devsu.account_service.application.configuration",
	"com.devsu.account_service.application.handlers",
	"com.devsu.account_service.application.controller",
	"com.devsu.account_service.infrastructure.persistence"
  }
)
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

}
