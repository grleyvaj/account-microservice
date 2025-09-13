package com.devsu.account_service.application.beans;

import com.devsu.account_service.application.configuration.message.MessagingConfig;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import tools.jackson.databind.json.JsonMapper;

@Component
@Configuration
public class Messaging {

	@Bean
	public DirectExchange customerExchange(MessagingConfig messagingConfig) {
		return new DirectExchange(messagingConfig.getExchange());
	}

	@Bean
	public Queue customerCreatedQueue(MessagingConfig messagingConfig) {
		return QueueBuilder.durable(messagingConfig.getCreated().getQueue()).build();
	}

	@Bean
	public Queue customerUpdatedQueue(MessagingConfig messagingConfig) {
		return QueueBuilder.durable(messagingConfig.getUpdated().getQueue()).build();
	}

	@Bean
	public Queue customerDeletedQueue(MessagingConfig messagingConfig) {
		return QueueBuilder.durable(messagingConfig.getDeleted().getQueue()).build();
	}

	@Bean
	public Binding bindingCustomerCreated(
	  Queue customerCreatedQueue,
	  DirectExchange customerExchange,
	  MessagingConfig messagingConfig
	) {
		return BindingBuilder.bind(customerCreatedQueue)
		  .to(customerExchange)
		  .with(messagingConfig.getCreated().getRoutingKey());
	}

	@Bean
	public Binding bindingCustomerUpdated(
	  Queue customerUpdatedQueue,
	  DirectExchange customerExchange,
	  MessagingConfig messagingConfig
	) {
		return BindingBuilder.bind(customerUpdatedQueue)
		  .to(customerExchange)
		  .with(messagingConfig.getUpdated().getRoutingKey());
	}

	@Bean
	public Binding bindingCustomerDeleted(
	  Queue customerDeletedQueue,
	  DirectExchange customerExchange,
	  MessagingConfig messagingConfig
	) {
		return BindingBuilder.bind(customerDeletedQueue)
		  .to(customerExchange)
		  .with(messagingConfig.getDeleted().getRoutingKey());
	}

	@Bean
	public MessageConverter jacksonMessageConverter(JsonMapper jsonMapper) {
		return new JacksonJsonMessageConverter(jsonMapper);
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
	  ConnectionFactory cf,
	  MessageConverter converter
	) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(cf);
		factory.setMessageConverter(converter);
		return factory;
	}
}
