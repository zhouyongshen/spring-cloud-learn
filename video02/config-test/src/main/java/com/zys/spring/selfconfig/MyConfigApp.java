package com.zys.spring.selfconfig;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zys.spring.selfconfig")
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
