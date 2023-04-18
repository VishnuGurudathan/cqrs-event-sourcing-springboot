package com.codding.cqrs.order.query;

import com.codding.cqrs.order.query.exceptions.OrderServiceEventsExceptionHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderQueryServiceApplication.class, args);
	}


	@Autowired
	public void configure(EventProcessingConfigurer configurer) {
		configurer.registerListenerInvocationErrorHandler("order-query",
				configuration -> new OrderServiceEventsExceptionHandler());
	}
}
