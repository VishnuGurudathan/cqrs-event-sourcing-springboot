package com.codding.cqrs.order.command.dto;

import lombok.Data;

/**
 * @author vishnu.g
 */
@Data
public class OrderMessage {
    private String orderId;
    private Double orderAmount;
    private String orderDate;
    private String status;
}
