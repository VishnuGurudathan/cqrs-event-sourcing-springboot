package com.codding.cqrs.order.command.commands;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author vishnu.g
 */
@Data
public class UpdateOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private String status;
    private String transactionId;
}
