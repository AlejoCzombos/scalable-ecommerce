package com.microservice.product.services;

import com.microservice.product.models.dto.ProductDto;
import com.microservice.product.models.request.product.ProductCreateRequest;
import com.microservice.product.models.request.product.ProductUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto createProduct(ProductCreateRequest productDto);
    ProductDto updateProduct(ProductUpdateRequest productDto);
    ProductDto deleteProduct(Long id);

//    ProductDto addStockForProduct(Long productId, int amount);
//    void removeStockOfProduct(Long productId, int amount);

}
