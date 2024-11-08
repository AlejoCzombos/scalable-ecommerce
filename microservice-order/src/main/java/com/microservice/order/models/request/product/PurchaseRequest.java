package com.microservice.order.models.request.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PurchaseRequest {

    @NotNull(message = "Product id is required")
    private Long productId;

    @Positive(message = "Quantity must be greater than 0")
    @NotNull(message = "Quantity is required")
    private Integer quantity;

}
