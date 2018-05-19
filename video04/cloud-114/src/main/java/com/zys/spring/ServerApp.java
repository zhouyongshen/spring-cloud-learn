package com.zys.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaServer
public class ServerApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入 A 或者 B");
        System.out.print("spring.profiles=    ");
        String profile=sc.next();
        new SpringApplicationBuilder(ServerApp.class)
                .profiles(profile)
                .run(args);

    }
}
