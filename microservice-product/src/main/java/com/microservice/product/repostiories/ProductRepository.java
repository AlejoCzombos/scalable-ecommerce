package com.microservice.product.repostiories;

import com.microservice.product.models.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM product p WHERE p.category_id = :categoryId ORDER BY category_id DESC")
    List<Product> findByCategoryId(@Param("categoryId") Long categoryId);

    List<Product> findAllByIdInOrderById(List<Long> ids);

    @Query(value = """
        SELECT p FROM Product p
        WHERE (:name IS NULL OR LOWER(p.name) LIKE %:name%)
        AND (:categoryName IS NULL OR LOWER(p.productCategory.name) LIKE %:categoryName%)
        AND (:minPrice IS NULL OR p.unitPrice >= :minPrice)
        AND (:maxPrice IS NULL OR p.unitPrice <= :maxPrice)
        AND (:inStock IS NULL OR (:inStock = TRUE AND p.stock > 0) OR (:inStock = FALSE AND p.stock = 0))
        """)
    Page<Product> findByFilters(
            @Param("name") String name,
            @Param("categoryName") String categoryName,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("inStock") Boolean inStock,
            Pageable pageable
    );
}
