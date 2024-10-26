package com.microservice.product.controllers.imp;

import com.microservice.product.controllers.ProductControllerAPI;
import com.microservice.product.models.dto.ProductDto;
import com.microservice.product.models.request.product.ProductCreateRequest;
import com.microservice.product.models.request.product.ProductUpdateRequest;
import com.microservice.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductControllerAPI {

    private final ProductService productService;

    @Override
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> getProductById(Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> createProduct(ProductCreateRequest productDto) {
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductDto> updateProduct(ProductUpdateRequest productDto) {
        return new ResponseEntity<>(productService.updateProduct(productDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> deleteProduct(Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.NO_CONTENT);
    }
}
