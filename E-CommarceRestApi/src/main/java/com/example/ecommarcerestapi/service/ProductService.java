package com.example.ecommarcerestapi.service;

import com.example.ecommarcerestapi.model.Category;
import com.example.ecommarcerestapi.model.Customer;
import com.example.ecommarcerestapi.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct (Product product);
    List<Product> gitAllProduct ();
    Product getProductByID(long id);
    Product updateProduct (Product product , long id);
    void deleteProduct (long id);

}
