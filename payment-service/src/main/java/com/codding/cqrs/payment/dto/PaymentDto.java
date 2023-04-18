package com.codding.cqrs.payment.dto;

import lombok.Data;

/**
 * @author vishnu.g
 */
@Data
public class PaymentDto {
    private String orderId;
    private Double amount;
    private String orderDate;
    private String createdDate;
    private String transactionId;
}
