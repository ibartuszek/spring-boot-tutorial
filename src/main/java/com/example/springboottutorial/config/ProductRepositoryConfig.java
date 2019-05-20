package com.example.springboottutorial.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springboottutorial.product.domain.Product;

@Configuration
public class ProductRepositoryConfig {

    @Bean
    public Map<String, Product> productRepository() {
        Map<String, Product> productRepo = new HashMap<>();
        initProductRepo(productRepo);
        return productRepo;
    }

    private void initProductRepo(final Map<String, Product> productRepo) {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }
}
