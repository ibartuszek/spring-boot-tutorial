package com.example.springboottutorial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${spring.application.name:default_name}")
    private String name;

    @Value("${missing.property:there_is_no_value}")
    private String missingProperty;

    @RequestMapping(value = "/")
    public String hello() {
        System.out.println(missingProperty);
        return name;
    }

}
