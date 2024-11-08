package com.microservice.product.mappers.product;

import com.microservice.product.models.dto.ProductPurchaseResponse;
import com.microservice.product.models.entities.Product;

public class ProductPurchaseMapper {

    public static ProductPurchaseResponse toproductPurchaseResponse(Product product){
        return ProductPurchaseResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .unitPrice(product.getUnitPrice())
                .imageUrl(product.getImageUrl())
                .stock(product.getStock())
                .build();
    }

}
