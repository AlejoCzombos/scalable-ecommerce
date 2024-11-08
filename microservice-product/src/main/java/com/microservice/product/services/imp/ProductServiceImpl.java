package com.microservice.product.services.imp;

import com.microservice.product.exceptions.custom.product.ProductNameAlreadyExistsException;
import com.microservice.product.exceptions.custom.product.ProductNotFoundException;
import com.microservice.product.exceptions.custom.product.ProductPurchaseException;
import com.microservice.product.exceptions.custom.productCategory.ProductCategoryNotFoundException;
import com.microservice.product.mappers.PageResponseMapper;
import com.microservice.product.mappers.product.ProductCreateRequestMapper;
import com.microservice.product.mappers.product.ProductDtoMapper;
import com.microservice.product.mappers.product.ProductPurchaseMapper;
import com.microservice.product.models.dto.PageResponse;
import com.microservice.product.models.dto.ProductDto;
import com.microservice.product.models.dto.ProductPurchaseResponse;
import com.microservice.product.models.entities.Product;
import com.microservice.product.models.request.filter.ProductFilter;
import com.microservice.product.models.request.product.ProductCreateRequest;
import com.microservice.product.models.request.product.ProductPurchaseRequest;
import com.microservice.product.models.request.product.ProductUpdateRequest;
import com.microservice.product.repostiories.ProductCategoryRepository;
import com.microservice.product.repostiories.ProductRepository;
import com.microservice.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
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
    public PageResponse<ProductDto> getAllProductsWithFilter(ProductFilter filter) {

        if (!List.of("id", "name", "unitPrice", "stock").contains(filter.getOrderBy().getField())) {
            throw new IllegalArgumentException("The field to order by must be one of the following: id, name, categoryName, unitPrice, stock");
        }

        Pageable pageable = PageRequest.of(
                filter.getPage(),
                filter.getSize(),
                filter.getOrderBy().isAscending() ?
                        Sort.by(filter.getOrderBy().getField()).ascending() :
                        Sort.by(filter.getOrderBy().getField()).descending()
        );

        if (repository.existsByName(filter.getName())) {
            throw new ProductNotFoundException(ProductNotFoundException.MESSAGE + "with name: " + filter.getName());
        }
        if (categoryRepository.existsByName(filter.getCategoryName())) {
            throw new ProductCategoryNotFoundException(ProductCategoryNotFoundException.MESSAGE + "with name: " + filter.getCategoryName());
        }

        Page<Product> products = repository.findByFilters(
                filter.getName() != null ? filter.getName().toLowerCase() : null,
                filter.getCategoryName() != null ? filter.getCategoryName().toLowerCase() : null,
                filter.getMinPrice(),
                filter.getMaxPrice(),
                filter.getInStock(),
                pageable
        );

        products.getPageable().getPageNumber();
        return PageResponseMapper.convertToPageResponse(products, ProductDtoMapper::toProductDto);
    }

    @Override
    @Transactional(rollbackFor = ProductPurchaseException.class)
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> purchase) {
        List<Long> productIds = purchase.stream().map(ProductPurchaseRequest::getProductId).toList();
        List<Product> storedProducts = repository.findAllByIdInOrderById(productIds);

        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("Some products were not found");
        }

        List<ProductPurchaseRequest> sortedRequest = purchase.stream().sorted(Comparator.comparing(ProductPurchaseRequest::getProductId)).toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if (product.getStock() < productRequest.getQuantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with id " + productRequest.getProductId());
            }
            var newStock = product.getStock() - productRequest.getQuantity();
            product.setStock(newStock);
            Product savedProduct = repository.save(product);
            purchasedProducts.add(ProductPurchaseMapper.toproductPurchaseResponse(savedProduct));
        }
        return purchasedProducts;
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

    @Override
    public ProductDto addStockForProduct(Long productId, int amount) {
        Product product = repository.findById(productId).orElseThrow(() -> new ProductNotFoundException(ProductNotFoundException.MESSAGE + "with id: " + productId));

        product.setStock(product.getStock() + amount);
        Product productSaved = repository.save(product);

        return ProductDtoMapper.toProductDto(productSaved);
    }

    @Override
    public ProductDto removeStockOfProduct(Long productId, int amount) {
        Product product = repository.findById(productId).orElseThrow(() -> new ProductNotFoundException(ProductNotFoundException.MESSAGE + "with id: " + productId));

        if (product.getStock() - amount < 0) {
            throw new IllegalArgumentException("The amount to remove is greater than the stock of the product");
        }

        product.setStock(product.getStock() - amount);
        Product productSaved = repository.save(product);

        return ProductDtoMapper.toProductDto(productSaved);
    }

}
