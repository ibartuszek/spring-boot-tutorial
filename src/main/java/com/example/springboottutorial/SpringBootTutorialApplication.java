package com.example.springboottutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTutorialApplication /* extends SpringBootServletInitializer */ implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutorialApplication.class, args);
    }

    //    @Override
    //    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    //        return application.sources(SpringBootTutorialApplication.class);
    //    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        System.out.println("Hello World from Application Runner");
    }

}
