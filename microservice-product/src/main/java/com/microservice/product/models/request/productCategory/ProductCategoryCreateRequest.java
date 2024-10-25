package com.microservice.product.models.request.productCategory;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductCategoryCreateRequest {

    @NotBlank(message = "Category name is required")
    private String name;
    private String description;

}
