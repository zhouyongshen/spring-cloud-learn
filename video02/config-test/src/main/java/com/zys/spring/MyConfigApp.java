package com.zys.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MyConfigApp {
    public static void main(String[] args) {

//        new SpringApplicationBuilder(MyConfigApp.class)
//                .properties("spring.config.location=classpath:/abc.properties")
//                .run(args);

        new SpringApplicationBuilder(MyConfigApp.class)
                .properties("spring.config.location=classpath:/abc.yml")
                .run(args);
    }
}
