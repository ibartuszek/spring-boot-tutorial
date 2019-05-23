package com.example.productapp.simplecontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Value("${spring.application.name:default_name}")
    private String name;

    @RequestMapping(value = "/hello")
    public String hello() {
        HelloController.LOGGER.info(name);
        return name;
    }

}
