package com.microservice.product.models.request.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilter {

    private Integer page;
    private Integer size;
    private String name;
    private String categoryName;
    private Double minPrice;
    private Double maxPrice;
    private Boolean inStock;
    private OrderBy orderBy;

}
