package com.microservice.product.services.imp;

import com.microservice.product.exceptions.custom.productCategory.ProductCategoryNameAlreadyExistsException;
import com.microservice.product.exceptions.custom.productCategory.ProductCategoryNotFoundException;
import com.microservice.product.mappers.PageResponseMapper;
import com.microservice.product.mappers.productCategory.ProductCategoryCreateRequestMapper;
import com.microservice.product.mappers.productCategory.ProductCategoryDtoMapper;
import com.microservice.product.models.dto.PageResponse;
import com.microservice.product.models.dto.ProductCategoryDto;
import com.microservice.product.models.entities.ProductCategory;
import com.microservice.product.models.request.productCategory.ProductCategoryCreateRequest;
import com.microservice.product.models.request.productCategory.ProductCategoryUpdateRequest;
import com.microservice.product.repostiories.ProductCategoryRepository;
import com.microservice.product.services.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository repository;

    @Override
    public PageResponse<ProductCategoryDto> getAllProducts(Pageable pageable) {
        Page<ProductCategory> productCategories = repository.findAll(pageable);
        productCategories.getPageable().getPageNumber();

        return PageResponseMapper.convertToPageResponse(productCategories, ProductCategoryDtoMapper::toProductCategoryDto);
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
            throw new ProductCategoryNameAlreadyExistsException(ProductCategoryNameAlreadyExistsException.MESSAGE + "with name: " + productCategory.getName());
        }

        ProductCategory productCategorySaved = repository.save(productCategory);

        return ProductCategoryDtoMapper.toProductCategoryDto(productCategorySaved);
    }

    @Override
    public ProductCategoryDto updateProduct(ProductCategoryUpdateRequest productDto) {
        ProductCategory productCategory = repository.findById(productDto.getId()).orElseThrow( () -> new ProductCategoryNotFoundException(ProductCategoryNotFoundException.MESSAGE + "with id: " + productDto.getId()));

        if (repository.existsByName(productCategory.getName())) {
            throw new ProductCategoryNameAlreadyExistsException(ProductCategoryNameAlreadyExistsException.MESSAGE + "with name: " + productCategory.getName());
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
