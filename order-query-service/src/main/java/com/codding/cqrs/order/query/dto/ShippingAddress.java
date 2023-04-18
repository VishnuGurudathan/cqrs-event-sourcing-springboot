package com.codding.cqrs.order.query.dto;

import lombok.Data;

/**
 * @author vishnu.g
 */
@Data
public class ShippingAddress {

    private String shippingFirstName;
    private String shippingLastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private long zipCode;
    private String country;
}
