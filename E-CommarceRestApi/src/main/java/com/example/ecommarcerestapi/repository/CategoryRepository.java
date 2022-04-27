package com.example.ecommarcerestapi.repository;

import com.example.ecommarcerestapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
