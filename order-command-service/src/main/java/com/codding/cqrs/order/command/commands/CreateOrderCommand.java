package com.codding.cqrs.order.command.commands;

import com.codding.cqrs.order.command.dto.BillingAddress;
import com.codding.cqrs.order.command.dto.Product;
import com.codding.cqrs.order.command.dto.ShippingAddress;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;

/**
 * @author vishnu.g
 */
@Data
public class CreateOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private String customerId;
    private String createdDate;
    private String updatedDate;
    private Double orderAmount;
    private String status;
    private String invoiceNumber;
    private String transactionId;
    private String createdBy;
    private String updatedBy;
    private List<Product> products;
    private ShippingAddress shippingAddress;
    private BillingAddress billingAddress;
}
