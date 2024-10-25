package com.microservice.product.controllers;

import com.microservice.product.models.dto.ProductDto;
import com.microservice.product.models.request.product.ProductCreateRequest;
import com.microservice.product.models.request.product.ProductUpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/api/products")
public interface ProductControllerAPI {

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET
    )
    ResponseEntity<List<ProductDto>> getAllProducts();

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

}
