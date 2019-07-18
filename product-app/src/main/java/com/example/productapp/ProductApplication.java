package com.example.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// Client of EurekaServerApplication and ZuulProxyServerApplication
// RestController: ProductController
// File upload/download: FileDownloadController, FileUploadController
// Example interceptor: ProductServiceInterceptor - Log during preHandle, postHandle, afterCompletion
// Example filter: SimpleFilter - Log some data
// Locale resolver: config -> WebMvcConfig
// RestTemplate: ConsumeWebService + config -> WebMvcConfig
// Thymeleaf examples: ViewController + WebController

@SpringBootApplication
@EnableEurekaClient
public class ProductApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProductApplication.class);
    }

}
