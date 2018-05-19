package com.zys.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class PoliceApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入 8010 或者 8011");
        System.out.print("server.port=  ");
        String port=sc.nextLine();
        new SpringApplicationBuilder(PoliceApp.class)
                .web(true)
                .properties("server.port="+port)
                .run(args);
    }
}
