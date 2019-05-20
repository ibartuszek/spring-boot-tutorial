package com.example.springboottutorial.product.service;

import java.util.Collection;

import com.example.springboottutorial.product.domain.Product;

public interface ProductService {

    void createProduct(Product product);

    void updateProduct(String id, Product product);

    void deleteProduct(String id);

    Collection<Product> getProducts();

}
