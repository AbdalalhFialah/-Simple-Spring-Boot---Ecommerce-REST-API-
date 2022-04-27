package com.example.ecommarcerestapi.service.impl;

import com.example.ecommarcerestapi.exception.ResourceNotFoundException;
import com.example.ecommarcerestapi.model.Customer;
import com.example.ecommarcerestapi.model.Product;
import com.example.ecommarcerestapi.repository.ProductRepository;
import com.example.ecommarcerestapi.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> gitAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByID(long id) {
        return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","Id",id));
    }

    @Override
    public Product updateProduct(Product product, long id) {
        Product productExsit = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","Id",id));
        productExsit.setProducPrice(product.getProducPrice());
        productExsit.setProducName(product.getProducName());

        productRepository.save(productExsit);

        return productExsit;
    }

    @Override
    public void deleteProduct(long id) {
        // First Check Id OF Product Is Found Or Not
        // If Not Found Then throw ResourceNotFoundException
        // if Found then delete It.
        productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","Id",id));
        productRepository.deleteById(id);

    }
}
