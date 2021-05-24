package com.sha.springbootmicroservice1product.repository;

import com.sha.springbootmicroservice1product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product,Long> {
   /* @Query("select * ")
    Product findByPriceGreaterThan(); */
}
