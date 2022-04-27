package com.example.ecommarcerestapi.repository;

import com.example.ecommarcerestapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
