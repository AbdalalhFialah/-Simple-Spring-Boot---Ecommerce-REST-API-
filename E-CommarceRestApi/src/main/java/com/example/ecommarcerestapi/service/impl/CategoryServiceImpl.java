package com.example.ecommarcerestapi.service.impl;

import com.example.ecommarcerestapi.exception.ResourceNotFoundException;
import com.example.ecommarcerestapi.model.Category;
import com.example.ecommarcerestapi.repository.CategoryRepository;
import com.example.ecommarcerestapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> gitAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByID(long id) {

        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category","Id",id));
    }

    @Override
    public Category updateCategory(Category category, long id) {
        Category categoryExsist = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category","Id",id));
        categoryExsist.setCreationDate(category.getCreationDate());
        categoryExsist.setCategory_name(category.getCategory_name());
        categoryExsist.setDescription(category.getCategory_name());

        // Save
        categoryRepository.save(categoryExsist);
        return categoryExsist;
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category","Id",id));

        categoryRepository.deleteById(id);


    }
}
