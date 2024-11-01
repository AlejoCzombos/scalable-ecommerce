package com.microservice.product.services.imp;

import com.microservice.product.exceptions.custom.product.ProductNameAlreadyExistsException;
import com.microservice.product.exceptions.custom.product.ProductNotFoundException;
import com.microservice.product.exceptions.custom.productCategory.ProductCategoryNotFoundException;
import com.microservice.product.mappers.PageResponseMapper;
import com.microservice.product.mappers.product.ProductCreateRequestMapper;
import com.microservice.product.mappers.product.ProductDtoMapper;
import com.microservice.product.models.dto.PageResponse;
import com.microservice.product.models.dto.ProductDto;
import com.microservice.product.models.entities.Product;
import com.microservice.product.models.request.product.ProductCreateRequest;
import com.microservice.product.models.request.product.ProductUpdateRequest;
import com.microservice.product.repostiories.ProductCategoryRepository;
import com.microservice.product.repostiories.ProductRepository;
import com.microservice.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductCategoryRepository categoryRepository;

    @Override
    public PageResponse<ProductDto> getAllProducts(Pageable pageable) {
        Page<Product> products = repository.findAll(pageable);
        products.getPageable().getPageNumber();

        return PageResponseMapper.convertToPageResponse(products, ProductDtoMapper::toProductDto);
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = repository.findById(id).orElseThrow( () -> new ProductNotFoundException(ProductNotFoundException.MESSAGE + "with id: " + id));

        return ProductDtoMapper.toProductDto(product);
    }

    @Override
    public ProductDto createProduct(ProductCreateRequest productDto) {
        Product product = ProductCreateRequestMapper.toProduct(productDto);

        if (repository.existsByName(product.getName())) {
            throw new ProductNameAlreadyExistsException(ProductNameAlreadyExistsException.MESSAGE + "with name: " + product.getName());
        }

        if (!categoryRepository.existsById(productDto.getCategoryId())) {
            throw new ProductCategoryNotFoundException(ProductCategoryNotFoundException.MESSAGE + "with id: " + productDto.getCategoryId());
        }
        product.setProductCategory(categoryRepository.getById(productDto.getCategoryId()));

        Product productSaved = repository.save(product);

        return ProductDtoMapper.toProductDto(productSaved);
    }

    @Override
    public ProductDto updateProduct(ProductUpdateRequest productDto) {
        Product product = repository.findById(productDto.getId()).orElseThrow( () -> new ProductNotFoundException(ProductNotFoundException.MESSAGE + "with id: " + productDto.getId()));

        if (repository.existsByName(productDto.getName())) {
            throw new ProductNameAlreadyExistsException(ProductNameAlreadyExistsException.MESSAGE + "with name: " + productDto.getName());
        }

        if (!categoryRepository.existsById(productDto.getCategoryId())) {
            throw new ProductCategoryNotFoundException(ProductCategoryNotFoundException.MESSAGE + "with id: " + productDto.getCategoryId());
        }
        product.setProductCategory(categoryRepository.getById(productDto.getCategoryId()));

        Product productSaved = repository.save(product);

        return ProductDtoMapper.toProductDto(productSaved);
    }

    @Override
    public ProductDto deleteProduct(Long id) {
        Product product = repository.findById(id).orElseThrow( () -> new ProductNotFoundException(ProductNotFoundException.MESSAGE + "with id: " + id));

        repository.delete(product);

        return ProductDtoMapper.toProductDto(new Product());
    }
}
