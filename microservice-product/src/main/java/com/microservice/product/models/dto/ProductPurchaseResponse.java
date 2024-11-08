package com.microservice.product.models.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductPurchaseResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private Integer stock;
}
