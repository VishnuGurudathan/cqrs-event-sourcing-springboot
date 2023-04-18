package com.codding.cqrs.order.command.events;

import com.codding.cqrs.order.command.entities.BillingAddress;
import com.codding.cqrs.order.command.entities.Order;
import com.codding.cqrs.order.command.entities.Product;
import com.codding.cqrs.order.command.entities.ShippingAddress;
import com.codding.cqrs.order.command.events.publisher.PaymentEventPublisher;
import com.codding.cqrs.order.command.repositories.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author vishnu.g
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreateEventHandler {
    private final OrderRepository orderRepository;
    private final PaymentEventPublisher paymentEventPublisher;

    @EventHandler
    public void on(OrderCreateEvent orderCreateEvent) throws JsonProcessingException {
        log.debug("Handling {} event: {}", orderCreateEvent.getClass().getSimpleName(), orderCreateEvent.getOrderId());
        Order order = new Order();
        BeanUtils.copyProperties(orderCreateEvent, order);

        ShippingAddress shippingAddress = new ShippingAddress();
        BillingAddress billingAddress = new BillingAddress();

        BeanUtils.copyProperties(orderCreateEvent.getShippingAddress(), shippingAddress);
        order.setShippingAddress(shippingAddress);

        BeanUtils.copyProperties(orderCreateEvent.getBillingAddress(), billingAddress);
        order.setBillingAddress(billingAddress);

        var productEntities = orderCreateEvent.getProducts().stream()
                .map(dto -> new Product(dto.getProductId(), dto.getProductName(), dto.getQuantity(), dto.getPrice()))
                .toList();
        order.setProducts(productEntities);

        orderRepository.save(order);

        paymentEventPublisher.initiatePaymentEvent(order);
        log.trace("Done handling {} event: {}", orderCreateEvent.getClass().getSimpleName(), orderCreateEvent.getOrderId());
    }
}
