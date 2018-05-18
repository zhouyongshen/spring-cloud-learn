package com.zys.spring.defaultconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ConfigApp {
    public static void main(String[] args) {

        SpringApplication.run(ConfigApp.class,args);

    }
}
