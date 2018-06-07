package com.zys.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SourceApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SourceApp.class).run(args);
    }
}
