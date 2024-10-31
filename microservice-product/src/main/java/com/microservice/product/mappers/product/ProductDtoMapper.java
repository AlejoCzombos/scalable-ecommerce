package com.microservice.product.mappers.product;

import com.microservice.product.mappers.productCategory.ProductCategoryDtoMapper;
import com.microservice.product.models.dto.ProductDto;
import com.microservice.product.models.entities.Product;

public class ProductDtoMapper {

    public static ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .unitPrice(product.getUnitPrice())
                .stock(product.getStock())
                .imageUrl(product.getImageUrl())
                .category(ProductCategoryDtoMapper.toProductCategoryDto(product.getProductCategory()))
                .build();
    }

}
