package com.microservice.product.mappers.product;

import com.microservice.product.models.entities.Product;
import com.microservice.product.models.request.product.ProductUpdateRequest;

public class ProductUpdateRequestMapper {

    public static Product toProduct(ProductUpdateRequest request) {
        Product newProduct = new Product();
        if (request.getId() != null){
            newProduct.setId(request.getId());
        }
        if (request.getName() != null) {
            newProduct.setName(request.getName());
        }
        if (request.getDescription() != null) {
            newProduct.setDescription(request.getDescription());
        }
        if (request.getUnitPrice() != null) {
            newProduct.setUnitPrice(request.getUnitPrice());
        }
        if (request.getStock() != null) {
            newProduct.setStock(request.getStock());
        }
        return newProduct;
    }

}
