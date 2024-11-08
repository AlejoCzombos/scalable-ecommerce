package com.microservice.order.models.dto.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private Integer stock;
    private String imageUrl;
    private Object category;
}
