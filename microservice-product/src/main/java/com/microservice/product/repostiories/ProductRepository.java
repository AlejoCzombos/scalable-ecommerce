package com.microservice.product.repostiories;

import com.microservice.product.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM products.product p WHERE p.category_id = categoryId ORDER BY ID DESC")
    List<Product> findByCategoryId(@Param("categoryId") Long categoryId);

}
