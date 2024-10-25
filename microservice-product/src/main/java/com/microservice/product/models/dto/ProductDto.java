package com.microservice.product.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private Integer stock;
    private String imageUrl;
    private ProductCategoryDto category;
}
