package com.microservice.product.mappers;

import com.microservice.product.models.dto.PageResponse;
import org.springframework.data.domain.Page;

import java.util.function.Function;

public class PageResponseMapper {

    public static <T, U> PageResponse<T> convertToPageResponse(Page<U> page, Function<U, T> mapper) {
        return PageResponse.<T>builder()
                .pageNumber(page.getPageable().getPageNumber())
                .pageSize(page.getPageable().getPageSize())
                .numberOfElements(page.getNumberOfElements())
                .content(page.getContent().stream().map(mapper).toList())
                .build();
    }
}
