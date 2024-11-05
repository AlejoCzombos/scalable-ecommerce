package com.microservice.product.models.request.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreateRequest {

    @NotBlank(message = "Product name is required")
    private String name;

    private String description;

    @NotNull(message = "Product unit price is required")
    @Positive(message = "Product unit price must be greater than zero")
    private BigDecimal unitPrice;

    @NotNull(message = "Product stock is required")
    @PositiveOrZero(message = "Product stock must be greater than or equal to zero")
    private Integer stock;

    private String imageUrl;

    @NotNull(message = "ProductCategory id is required")
    @Positive(message = "ProductCategory id must be greater than zero")
    private Long categoryId;
}
