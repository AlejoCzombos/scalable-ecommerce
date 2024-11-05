package com.microservice.product.services;

import com.microservice.product.models.dto.PageResponse;
import com.microservice.product.models.dto.ProductDto;
import com.microservice.product.models.entities.Product;
import com.microservice.product.models.request.filter.ProductFilter;
import com.microservice.product.models.request.product.ProductCreateRequest;
import com.microservice.product.models.request.product.ProductUpdateRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    PageResponse<ProductDto> getAllProducts(Pageable pageable);
    PageResponse<ProductDto> getAllProductsWithFilter(ProductFilter productFilter);
    ProductDto getProductById(Long id);
    ProductDto createProduct(ProductCreateRequest productDto);
    ProductDto updateProduct(ProductUpdateRequest productDto);
    ProductDto deleteProduct(Long id);
    ProductDto addStockForProduct(Long productId, int amount);
    ProductDto removeStockOfProduct(Long productId, int amount);

}
