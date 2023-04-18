package com.codding.cqrs.order.command.exceptions;

/**
 * @author vishnu.g
 */
public class OrderCreationException extends RuntimeException {
    public OrderCreationException() {
        super();
    }

    public OrderCreationException(String message) {
        super(message);
    }
}
