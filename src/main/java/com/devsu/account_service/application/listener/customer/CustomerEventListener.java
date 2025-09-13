package com.devsu.account_service.application.listener.customer;

import com.devsu.account_service.application.listener.customer.message.CustomerCreatedMessage;
import com.devsu.account_service.application.listener.customer.message.CustomerDeletedMessage;
import com.devsu.account_service.application.listener.customer.message.CustomerUpdatedMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@RequiredArgsConstructor
@Validated
@Slf4j
public class CustomerEventListener {

	@RabbitListener(queues = "${messaging.customer.created.queue}")
	public void handleCreated(CustomerCreatedMessage event) {
		log.info("Receiving customer CREATED: " + event.getClientId());
	}

	@RabbitListener(queues = "${messaging.customer.updated.queue}")
	public void handleUpdated(CustomerUpdatedMessage event) {
		log.info("Receiving customer UPDATED: " + event.getClientId());

	}

	@RabbitListener(queues = "${messaging.customer.deleted.queue}")
	public void handleDeleted(CustomerDeletedMessage event) {
		log.info("Receiving customer DELETED: " + event.getClientId());
	}

}