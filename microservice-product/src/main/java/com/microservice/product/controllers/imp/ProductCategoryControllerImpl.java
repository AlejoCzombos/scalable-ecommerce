package com.microservice.product.controllers.imp;

import com.microservice.product.controllers.ProductCategoryControllerAPI;
import com.microservice.product.models.dto.ProductCategoryDto;
import com.microservice.product.models.request.productCategory.ProductCategoryCreateRequest;
import com.microservice.product.models.request.productCategory.ProductCategoryUpdateRequest;
import com.microservice.product.services.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductCategoryControllerImpl implements ProductCategoryControllerAPI {

    private final ProductCategoryService productCategoryService;

    @Override
    public ResponseEntity<List<ProductCategoryDto>> getAllProducts() {
        return new ResponseEntity<>(productCategoryService.getAllProducts(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductCategoryDto> getProductById(Long id) {
        return new ResponseEntity<>(productCategoryService.getProductById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductCategoryDto> createProduct(ProductCategoryCreateRequest productDto) {
        return new ResponseEntity<>(productCategoryService.createProduct(productDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductCategoryDto> updateProduct(ProductCategoryUpdateRequest productDto) {
        return new ResponseEntity<>(productCategoryService.updateProduct(productDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductCategoryDto> deleteProduct(Long id) {
        return new ResponseEntity<>(productCategoryService.deleteProduct(id), HttpStatus.NO_CONTENT);
    }
}
