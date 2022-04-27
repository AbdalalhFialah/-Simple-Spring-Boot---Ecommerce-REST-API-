package com.example.ecommarcerestapi.contorller;

import com.example.ecommarcerestapi.model.Category;
import com.example.ecommarcerestapi.model.Customer;
import com.example.ecommarcerestapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryContoller {

    private CategoryService categoryService;

    public CategoryContoller(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public ResponseEntity<Category>saveCategory (@RequestBody Category category){
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }


   @GetMapping()
    public List<Category> getSCategory() {
        List<Category> categoryList = new ArrayList<Category>();
        for (int i = 0; i < 5; i++) {
            categoryList.add(new Category(i,"Iphone"+i,"2008-11-11","Model"+i));
        }
        return categoryList;
    }


    @GetMapping("/findAll")
    public List<Category>gitAllCustomer (){
        return categoryService.gitAllCategory();
    }
    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory (@RequestBody Category category ,@PathVariable("id")  long Catid){
        return new ResponseEntity<>(categoryService.updateCategory(category,Catid),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String >deleteCategory (@PathVariable("id") long catid){
        categoryService.deleteCategory(catid);
        return new ResponseEntity<>("Category Delete Successful",HttpStatus.OK);
    }

}
