package com.microservice.product.models.request.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateRequest {

    @NotNull(message = "Id is required")
    private Long id;

    private String name;

    private String description;

    @Positive(message = "Unit price must be greater than zero")
    private BigDecimal unitPrice;

    @Positive(message = "Stock must be greater than zero")
    private Integer stock;

    private String imageUrl;

    private Long categoryId;

}
