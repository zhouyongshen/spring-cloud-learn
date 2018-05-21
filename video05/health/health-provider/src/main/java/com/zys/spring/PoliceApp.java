package com.zys.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
public class PoliceApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PoliceApp.class)
                .web(true)
                .run(args);
    }
}
