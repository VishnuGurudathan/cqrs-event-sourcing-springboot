package com.codding.cqrs.order.query.dto;

import lombok.Data;

/**
 * @author vishnu.g
 */
@Data
public class Product {
    private String productId;
    private int qty;
}
