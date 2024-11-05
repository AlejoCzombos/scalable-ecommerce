package com.microservice.product.controllers.imp;

import com.microservice.product.controllers.ProductControllerAPI;
import com.microservice.product.models.dto.PageResponse;
import com.microservice.product.models.dto.ProductDto;
import com.microservice.product.models.request.filter.OrderBy;
import com.microservice.product.models.request.filter.ProductFilter;
import com.microservice.product.models.request.product.ProductCreateRequest;
import com.microservice.product.models.request.product.ProductUpdateRequest;
import com.microservice.product.services.ProductService;
import com.microservice.product.utils.UtilitiesFunctions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductControllerAPI {

    private final ProductService productService;

    @Override
    public ResponseEntity<PageResponse<ProductDto>> getAllProducts(int page, int size) {
        if(UtilitiesFunctions.isInvalidPageRequest(page, size)){
            throw new IllegalArgumentException("The amount of elements cannot be more than 50, and page index must not be less than zero");
        }
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(productService.getAllProducts(pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageResponse<ProductDto>> getAllProductsWithFilter(
            int page,
            int size,
            String name,
            String categoryName,
            Double minPrice,
            Double maxPrice,
            Boolean inStock,
            Boolean ascending,
            String order_field
    ) {
        if(UtilitiesFunctions.isInvalidPageRequest(page, size)){
            throw new IllegalArgumentException("The amount of elements cannot be more than 50, and page index must not be less than zero");
        }

        ProductFilter productFilter = ProductFilter.builder()
                .page(page)
                .size(size)
                .name(name)
                .categoryName(categoryName)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .inStock(inStock)
                .orderBy(new OrderBy(ascending == null ? true : ascending, order_field == null ? "id" : order_field))
                .build();

        return new ResponseEntity<>(productService.getAllProductsWithFilter(productFilter), HttpStatus.OK);
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
