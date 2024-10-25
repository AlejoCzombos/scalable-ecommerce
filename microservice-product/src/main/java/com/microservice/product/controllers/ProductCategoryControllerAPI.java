package com.microservice.product.controllers;

import com.microservice.product.models.dto.ProductCategoryDto;
import com.microservice.product.models.request.productCategory.ProductCategoryCreateRequest;
import com.microservice.product.models.request.productCategory.ProductCategoryUpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/api/product-category")
public interface ProductCategoryControllerAPI {

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET
    )
    ResponseEntity<List<ProductCategoryDto>> getAllProducts();

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
