package com.microservice.product.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCategoryDto {
    private Long id;
    private String name;
    private String description;
}
