package com.microservice.product.mappers.productCategory;

import com.microservice.product.models.dto.ProductCategoryDto;
import com.microservice.product.models.entities.ProductCategory;

public class ProductCategoryDtoMapper {

    public static ProductCategoryDto toProductCategoryDto(ProductCategory productCategory) {
        return ProductCategoryDto.builder()
                .id(productCategory.getId())
                .name(productCategory.getName())
                .description(productCategory.getDescription())
                .build();
    }

}
