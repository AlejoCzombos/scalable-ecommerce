package com.microservice.product.models.request.productCategory;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductCategoryUpdateRequest {

    @NotNull(message = "Category id is required")
    @Positive(message = "Category id must be positive")
    private Long id;
    private String name;
    private String description;
}
