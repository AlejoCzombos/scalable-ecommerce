package com.microservice.product.models.request.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductPurchaseRequest {
    @NotNull(message = "Product id is required")
    private Long productId;

    @Positive(message = "Quantity should be greater than zero")
    private Integer quantity;
}
