package com.microservice.product.mappers.productCategory;

import com.microservice.product.models.entities.ProductCategory;
import com.microservice.product.models.request.productCategory.ProductCategoryCreateRequest;

public class ProductCategoryCreateRequestMapper {

    public static ProductCategory toProductCategory(ProductCategoryCreateRequest productCategoryCreateRequest) {
        return ProductCategory.builder()
                .name(productCategoryCreateRequest.getName())
                .description(productCategoryCreateRequest.getDescription())
                .build();
    }

}
