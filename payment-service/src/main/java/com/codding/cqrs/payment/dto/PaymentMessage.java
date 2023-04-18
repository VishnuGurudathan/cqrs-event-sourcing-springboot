package com.codding.cqrs.payment.dto;

import lombok.Data;

/**
 * @author vishnu.g
 */
@Data
public class PaymentMessage {
    private String orderId;
    private Double orderAmount;
    private String orderDate;
    private String status;
    private String transactionId;
}
