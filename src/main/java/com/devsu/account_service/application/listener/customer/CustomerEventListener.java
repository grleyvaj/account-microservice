package com.devsu.account_service.application.listener.customer;

import com.devsu.account_service.application.contract.Mapper;
import com.devsu.account_service.application.listener.customer.message.CustomerCreatedMessage;
import com.devsu.account_service.application.listener.customer.message.CustomerDeletedMessage;
import com.devsu.account_service.application.listener.customer.message.CustomerUpdatedMessage;
import com.devsu.account_service.domain.use_cases.customer.create.CustomerCreateInput;
import com.devsu.account_service.domain.use_cases.customer.create.CustomerCreateUseCase;
import com.devsu.account_service.domain.use_cases.customer.delete.CustomerDeleteUseCase;
import com.devsu.account_service.domain.use_cases.customer.update.CustomerUpdateInput;
import com.devsu.account_service.domain.use_cases.customer.update.CustomerUpdateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.validation.annotation.Validated;

@RequiredArgsConstructor
@Validated
@Slf4j
public class CustomerEventListener {

	private final CustomerCreateUseCase customerCreateUseCase;
	private final CustomerUpdateUseCase customerUpdateUseCase;
	private final CustomerDeleteUseCase customerDeleteUseCase;
	private final Mapper<CustomerCreatedMessage, CustomerCreateInput> customerCreateInputMapper;
	private final Mapper<CustomerUpdatedMessage, CustomerUpdateInput> customerUpdateInputMapper;

	@RabbitListener(queues = "${messaging.customer.created.queue}")
	public void handleCreated(CustomerCreatedMessage event) {
		log.info("Receiving customer CREATED: " + event.getClientId());
		this.customerCreateUseCase.execute(
		  this.customerCreateInputMapper.map(event)
		);
	}

	@RabbitListener(queues = "${messaging.customer.updated.queue}")
	public void handleUpdated(CustomerUpdatedMessage event) {
		log.info("Receiving customer UPDATED: " + event.getClientId());
		this.customerUpdateUseCase.execute(
		  this.customerUpdateInputMapper.map(event)
		);
	}

	@RabbitListener(queues = "${messaging.customer.deleted.queue}")
	public void handleDeleted(CustomerDeletedMessage event) {
		log.info("Receiving customer DELETED: " + event.getClientId());
		this.customerDeleteUseCase.execute(event.getClientId(), event.getDeletedAt());
	}

}