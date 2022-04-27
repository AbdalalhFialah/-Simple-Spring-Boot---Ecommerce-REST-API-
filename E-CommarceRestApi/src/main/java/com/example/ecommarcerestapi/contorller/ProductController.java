package com.example.ecommarcerestapi.contorller;

import com.example.ecommarcerestapi.model.Category;
import com.example.ecommarcerestapi.model.Product;
import com.example.ecommarcerestapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public List<Product> getSCategory() {
        List<Product> ProductList = new ArrayList<Product>();
        for (int i = 0; i < 5; i++) {
            ProductList.add(new Product(i,"laptops",100*(2*i+1)));
        }
        return ProductList;
    }
    @PostMapping
    public ResponseEntity<Product>saveProduct (@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }
    @GetMapping("/findAll")
    public List<Product>gettAllProduct (){
        return productService.gitAllProduct();
    }
    @PutMapping("{id}")
    public ResponseEntity<Product>updateProduct (@PathVariable("id") long productId , @RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product,productId),HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String >deleteProduct (@PathVariable("id") long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Delete Prodcut Was Done Successful",HttpStatus.OK);
    }

}
