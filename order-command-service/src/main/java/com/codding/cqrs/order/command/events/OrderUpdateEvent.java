package com.codding.cqrs.order.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vishnu.g
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateEvent {
    private String orderId;
    private String status;
    private String transactionId;
}
