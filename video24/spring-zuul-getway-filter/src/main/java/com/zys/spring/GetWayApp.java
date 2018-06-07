package com.zys.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableZuulProxy
public class GetWayApp {
    public static void main(String[] args) {

        new SpringApplicationBuilder(GetWayApp.class).web(true).run(args);

    }
}
