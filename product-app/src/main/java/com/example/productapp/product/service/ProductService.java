package com.example.productapp.product.service;

import java.util.Collection;

import com.example.productapp.product.domain.Product;

public interface ProductService {

    void createProduct(Product product);

    void updateProduct(String id, Product product);

    void deleteProduct(String id);

    Collection<Product> getProducts();

}
