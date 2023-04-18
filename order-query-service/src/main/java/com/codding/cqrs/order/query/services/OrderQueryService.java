package com.codding.cqrs.order.query.services;

import com.codding.cqrs.order.query.dto.OrderDto;
import com.codding.cqrs.order.query.dto.OrderResults;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author vishnu.g
 */
public interface OrderQueryService {
    public CompletableFuture<OrderResults> retrieveAllOrders(Integer page, Integer size, String sort);

    public CompletableFuture<Optional<OrderDto>> getOrderById(String orderId);
}
