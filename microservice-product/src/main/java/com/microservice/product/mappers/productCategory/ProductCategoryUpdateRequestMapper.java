package com.microservice.product.mappers.productCategory;

import com.microservice.product.models.entities.ProductCategory;
import com.microservice.product.models.request.productCategory.ProductCategoryUpdateRequest;

public class ProductCategoryUpdateRequestMapper {

    public static ProductCategory toProductCategory(ProductCategoryUpdateRequest productCategoryDto) {
        ProductCategory productCategory = new ProductCategory();
        if (productCategoryDto.getId() != null) {
            productCategory.setId(productCategoryDto.getId());
        }
        if (productCategoryDto.getName() != null) {
            productCategory.setName(productCategoryDto.getName());
        }
        if (productCategoryDto.getDescription() != null) {
            productCategory.setDescription(productCategoryDto.getDescription());
        }
        return productCategory;
    }

}
