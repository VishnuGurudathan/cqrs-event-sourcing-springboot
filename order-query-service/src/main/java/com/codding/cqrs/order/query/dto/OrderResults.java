package com.codding.cqrs.order.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author vishnu.g
 */
@Data
public class OrderResults {
    @JsonProperty("orders")
    private List<OrderDto> orderDtoList;
    private Integer page;
    private Integer size;
    private Long total;
}
