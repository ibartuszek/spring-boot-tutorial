package com.example.productapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.productapp.product.ProductServiceInterceptor;

@Component
public class ProductServiceInterceptorAppConfig implements WebMvcConfigurer {

    @Autowired
    private ProductServiceInterceptor productServiceInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(productServiceInterceptor);
    }
}
