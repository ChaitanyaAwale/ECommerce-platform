package com.Chaitanya.Project1.E_Commerce.platform.repository;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String keyWord);

    List<Product> findByCategoryId(Long id);
    List<Product> findByPriceBetween(Double minPrice,Double maxPrice);

}