package com.microservice.product.mappers.product;

import com.microservice.product.models.entities.Product;
import com.microservice.product.models.request.product.ProductCreateRequest;

public class ProductCreateRequestMapper {

    public static Product toProduct(ProductCreateRequest request) {
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .unitPrice(request.getUnitPrice())
                .stock(request.getStock())
                .build();
    }

}
