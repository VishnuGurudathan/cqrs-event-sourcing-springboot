package com.codding.cqrs.order.command.services;

import com.codding.cqrs.order.command.commands.CreateOrderCommand;
import com.codding.cqrs.order.command.commands.UpdateOrderCommand;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @author vishnu.g
 */
public interface OrderCommandService {
    public CompletableFuture<String> createOrder(CreateOrderCommand createOrderCommand);

    public CompletableFuture<String> updateOrder(UpdateOrderCommand updateOrderCommand);
}
