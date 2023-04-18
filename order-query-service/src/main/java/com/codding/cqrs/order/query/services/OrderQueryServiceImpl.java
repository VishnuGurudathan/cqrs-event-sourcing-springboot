package com.codding.cqrs.order.query.services;

import com.codding.cqrs.order.query.dto.OrderDto;
import com.codding.cqrs.order.query.dto.OrderResults;
import com.codding.cqrs.order.query.utils.GetOrderQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author vishnu.g
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderQueryServiceImpl implements OrderQueryService {
    private final QueryGateway queryGateway;

    @Override
    public CompletableFuture<OrderResults> retrieveAllOrders(Integer page, Integer size, String sort) {
        GetOrderQuery getOrderQuery = GetOrderQuery.builder().page(page).size(size).sort(sort).build();
        return queryGateway.query(getOrderQuery, ResponseTypes.instanceOf(OrderResults.class));
    }

    @Override
    public CompletableFuture<Optional<OrderDto>> getOrderById(String orderId) {
        return queryGateway.query(orderId, ResponseTypes.optionalInstanceOf(OrderDto.class));
    }
}
