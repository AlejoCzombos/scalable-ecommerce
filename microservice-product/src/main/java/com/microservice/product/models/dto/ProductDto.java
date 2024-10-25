package com.microservice.product.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double unit_price;
    private Integer stock;
    private String image_url;
    private ProductCategoryDto category;
}
