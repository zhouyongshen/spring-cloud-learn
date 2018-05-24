package com.zys.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class PoliceApp {
    public static void main(String[] args) {
        System.out.print("请输入server.port(8090或8091)：");
        int port=new Scanner(System.in).nextInt();
        new SpringApplicationBuilder(PoliceApp.class)
                .web(true)
                .properties("server.port="+port)
                .run(args);
    }
}
