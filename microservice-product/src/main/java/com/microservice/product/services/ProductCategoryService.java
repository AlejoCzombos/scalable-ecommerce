package com.microservice.product.services;

import com.microservice.product.models.dto.ProductCategoryDto;
import com.microservice.product.models.request.productCategory.ProductCategoryCreateRequest;
import com.microservice.product.models.request.productCategory.ProductCategoryUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductCategoryService {

    List<ProductCategoryDto> getAllProducts();
    ProductCategoryDto getProductById(Long id);
    ProductCategoryDto createProduct(ProductCategoryCreateRequest productDto);
    ProductCategoryDto updateProduct(ProductCategoryUpdateRequest productDto);
    ProductCategoryDto deleteProduct(Long id);

}
