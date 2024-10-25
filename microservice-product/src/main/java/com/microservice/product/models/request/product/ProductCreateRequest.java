package com.microservice.product.models.request.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
public class ProductCreateRequest {

    @NotBlank(message = "Product name is required")
    private String name;

    private String description;

    @NotNull(message = "Product unit price is required")
    @Positive(message = "Product unit price must be greater than zero")
    private Double unit_price;

    @NotNull(message = "Product stock is required")
    @Positive(message = "Product stock must be greater than zero")
    private Integer stock;

    private String image_url;

    @NotNull(message = "ProductCategory id is required")
    @Positive(message = "ProductCategory id must be greater than zero")
    private Long category_id;
}
