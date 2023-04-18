package com.codding.cqrs.order.command;

import com.codding.cqrs.order.command.exceptions.OrderServiceEventsExceptionHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderCommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderCommandServiceApplication.class, args);
	}

	@Autowired
	public void configure(EventProcessingConfigurer configurer) {
		configurer.registerListenerInvocationErrorHandler("order-command",
				configuration -> new OrderServiceEventsExceptionHandler());
	}
}
