package com.example.productapp.product.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productapp.product.domain.Product;
import com.example.productapp.product.exception.ProductNotFoundException;

@Service
public class DefaultProductService implements ProductService {

    @Autowired
    private Map<String, Product> productRepo;

    @Override
    public void createProduct(final Product product) {
        productRepo.put(product.getId(), product);
    }

    @Override
    public void updateProduct(final String id, final Product product) {
        if (!productRepo.containsKey(id)) {
            throw new ProductNotFoundException();
        }
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
    }

    @Override
    public void deleteProduct(final String id) {
        productRepo.remove(id);
    }

    @Override
    public Collection<Product> getProducts() {
        return productRepo.values();
    }

}
