package com.example.springboottutorial;

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

    @Value("${missing.property:there_is_no_value}")
    private String missingProperty;

    @RequestMapping(value = "/")
    public String hello() {
        HelloController.LOGGER.info(missingProperty);
        return name;
    }

    // [%d{yyyy-MM-dd'T'HH:mm:ss.sss'Z'}] [%C] [%t] [%L] [%-5p] %m%n
    // [2019-05-03T14:54:51.051Z] [com.example.springboottutorial.HelloController] [http-nio-9091-exec-1] [22] [INFO ] there_is_no_value

}
