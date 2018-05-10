package com.zys.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
//        启动方式1
//        SpringApplication.run(App.class,args);
        //启动方式2
//        new SpringApplication(App.class).run(args);
        //启动方式3
        new SpringApplicationBuilder(App.class).run(args);

        //上述三种方式的底层均是使用了 new SpringApplication() 然后run()


    }
}
