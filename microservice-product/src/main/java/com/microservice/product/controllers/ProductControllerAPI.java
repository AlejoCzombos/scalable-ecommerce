package com.microservice.product.controllers;

import com.microservice.product.models.dto.PageResponse;
import com.microservice.product.models.dto.ProductDto;
import com.microservice.product.models.request.product.ProductCreateRequest;
import com.microservice.product.models.request.product.ProductUpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/products")
public interface ProductControllerAPI {

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET
    )
    ResponseEntity<PageResponse<ProductDto>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );

    @RequestMapping(
            value = "/filter",
            method = RequestMethod.GET
    )
    ResponseEntity<PageResponse<ProductDto>> getAllProductsWithFilter(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String categoryName,
                @PositiveOrZero(message = "minPrice must be greater than or equal to zero")
            @RequestParam(required = false) Double minPrice,
                @Positive(message = "maxPrice must be greater tan zero")
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Boolean inStock,
            @RequestParam(required = false) Boolean ascending,
            @RequestParam(required = false) String order_field
    );

    @RequestMapping(
            value = "/by-id/{id}",
            method = RequestMethod.GET
    )
    ResponseEntity<ProductDto> getProductById(
            @PathVariable
            @NotNull(message = "Id is required")
            Long id
    );

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST
    )
    ResponseEntity<ProductDto> createProduct(
            @Valid
            @RequestBody
            ProductCreateRequest productDto
    );

    @RequestMapping(
            value = "/update",
            method = RequestMethod.PUT
    )
    ResponseEntity<ProductDto> updateProduct(
            @Valid
            @RequestBody
            ProductUpdateRequest productDto
    );

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE
    )
    ResponseEntity<ProductDto> deleteProduct(
            @PathVariable
            @NotNull(message = "Id is required")
            Long id
    );

    @RequestMapping(
            value = "/add-stock/{productId}",
            method = RequestMethod.PATCH
    )
    ResponseEntity<ProductDto> addStockForProduct(
            @PathVariable
            @NotNull(message = "Product id is required")
            Long productId,
            @Positive(message = "Amount must be greater than zero")
            @RequestParam
            int amount
    );

    @RequestMapping(
            value = "/remove-stock/{productId}",
            method = RequestMethod.PATCH
    )
    ResponseEntity<ProductDto> removeStockOfProduct(
            @PathVariable
            @NotNull(message = "Product id is required")
            Long productId,
            @Positive(message = "Amount must be greater than zero")
            @RequestParam
            int amount
    );

}
