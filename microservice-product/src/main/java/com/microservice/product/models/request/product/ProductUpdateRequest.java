package com.microservice.product.models.request.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductUpdateRequest {

    @NotNull(message = "Id is required")
    private Long id;

    private String name;

    private String description;

    @Positive(message = "Unit price must be greater than zero")
    private Double unit_price;

    @Positive(message = "Stock must be greater than zero")
    private Integer stock;

    private String image_url;

    private Long category_id;

}
