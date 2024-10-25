package com.microservice.product.services.imp;

import com.microservice.product.exceptions.custom.productCategory.ProductCategoryNotFoundException;
import com.microservice.product.mappers.productCategory.ProductCategoryCreateRequestMapper;
import com.microservice.product.mappers.productCategory.ProductCategoryDtoMapper;
import com.microservice.product.models.dto.ProductCategoryDto;
import com.microservice.product.models.entities.ProductCategory;
import com.microservice.product.models.request.productCategory.ProductCategoryCreateRequest;
import com.microservice.product.models.request.productCategory.ProductCategoryUpdateRequest;
import com.microservice.product.repostiories.ProductCategoryRepository;
import com.microservice.product.services.ProductCategoryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository repository;

    @Override
    public List<ProductCategoryDto> getAllProducts() {
        List<ProductCategory> productCategories = repository.findAll();

        return productCategories.stream().map(ProductCategoryDtoMapper::toProductCategoryDto).toList();
    }

    @Override
    public ProductCategoryDto getProductById(Long id) {
        ProductCategory productCategory = repository.findById(id).orElseThrow( () -> new ProductCategoryNotFoundException(ProductCategoryNotFoundException.MESSAGE + "with id: " + id));

        return ProductCategoryDtoMapper.toProductCategoryDto(productCategory);
    }

    @Override
    public ProductCategoryDto createProduct(ProductCategoryCreateRequest productDto) {
        ProductCategory productCategory = ProductCategoryCreateRequestMapper.toProductCategory(productDto);

        if (repository.existsByName(productCategory.getName())) {
            throw new ProductCategoryNotFoundException(ProductCategoryNotFoundException.MESSAGE + "with name: " + productCategory.getName());
        }

        ProductCategory productCategorySaved = repository.save(productCategory);

        return ProductCategoryDtoMapper.toProductCategoryDto(productCategorySaved);
    }

    @Override
    public ProductCategoryDto updateProduct(ProductCategoryUpdateRequest productDto) {
        ProductCategory productCategory = repository.findById(productDto.getId()).orElseThrow( () -> new ProductCategoryNotFoundException(ProductCategoryNotFoundException.MESSAGE + "with id: " + productDto.getId()));

        if (repository.existsByName(productDto.getName())) {
            throw new ProductCategoryNotFoundException(ProductCategoryNotFoundException.MESSAGE + "with name: " + productDto.getName());
        }

        ProductCategory productCategorySaved = repository.save(productCategory);

        return ProductCategoryDtoMapper.toProductCategoryDto(productCategorySaved);
    }

    @Override
    public ProductCategoryDto deleteProduct(Long id) {
        ProductCategory productCategory = repository.findById(id).orElseThrow( () -> new ProductCategoryNotFoundException(ProductCategoryNotFoundException.MESSAGE + "with id: " + id));

        repository.delete(productCategory);

        return ProductCategoryDtoMapper.toProductCategoryDto(productCategory);
    }
}
