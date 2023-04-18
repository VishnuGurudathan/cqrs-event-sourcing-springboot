package com.codding.cqrs.order.command.dto;

import lombok.Data;

/**
 * @author vishnu.g
 */
@Data
public class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;
}
