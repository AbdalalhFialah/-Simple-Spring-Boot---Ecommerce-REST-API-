package com.example.ecommarcerestapi.service;

import com.example.ecommarcerestapi.model.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory (Category category);
    List<Category> gitAllCategory ();
    Category getCategoryByID(long id);
    Category updateCategory (Category category , long id);
    void deleteCategory (long id);

}
