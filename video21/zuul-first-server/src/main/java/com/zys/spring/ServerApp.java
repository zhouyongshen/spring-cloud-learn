package com.zys.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ServerApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ServerApp.class).run(args);
    }
}
