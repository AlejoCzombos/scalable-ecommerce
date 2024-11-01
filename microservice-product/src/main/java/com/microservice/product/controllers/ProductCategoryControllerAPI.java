package com.microservice.product.controllers;

import com.microservice.product.models.dto.PageResponse;
import com.microservice.product.models.dto.ProductCategoryDto;
import com.microservice.product.models.request.productCategory.ProductCategoryCreateRequest;
import com.microservice.product.models.request.productCategory.ProductCategoryUpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product-category")
public interface ProductCategoryControllerAPI {

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET
    )
    ResponseEntity<PageResponse<ProductCategoryDto>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );

    @RequestMapping(
            value = "/by-id/{id}",
            method = RequestMethod.GET
    )
    ResponseEntity<ProductCategoryDto> getProductById(
            @PathVariable
            @NotNull(message = "Id is required")
            Long id
    );

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST
    )
    ResponseEntity<ProductCategoryDto> createProduct(
            @Valid
            @RequestBody
            ProductCategoryCreateRequest productDto
    );

    @RequestMapping(
            value = "/update",
            method = RequestMethod.PUT
    )
    ResponseEntity<ProductCategoryDto> updateProduct(
            @Valid
            @RequestBody
            ProductCategoryUpdateRequest productDto
    );

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE
    )
    ResponseEntity<ProductCategoryDto> deleteProduct(
            @PathVariable
            @NotNull(message = "Id is required")
            Long id
    );

}
