package com.microservice.product.services;

import com.microservice.product.models.dto.PageResponse;
import com.microservice.product.models.dto.ProductCategoryDto;
import com.microservice.product.models.request.productCategory.ProductCategoryCreateRequest;
import com.microservice.product.models.request.productCategory.ProductCategoryUpdateRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface ProductCategoryService {

    PageResponse<ProductCategoryDto> getAllProducts(Pageable pageable);
    ProductCategoryDto getProductById(Long id);
    ProductCategoryDto createProduct(ProductCategoryCreateRequest productDto);
    ProductCategoryDto updateProduct(ProductCategoryUpdateRequest productDto);
    ProductCategoryDto deleteProduct(Long id);

}
