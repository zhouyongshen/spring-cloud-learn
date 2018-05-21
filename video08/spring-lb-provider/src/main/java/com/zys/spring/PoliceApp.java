package com.zys.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class PoliceApp {
    public static void main(String[] args) {
        System.out.print("请输入端口 server.port (8010 或者 8011)  ：");
        Scanner scanner=new Scanner(System.in);
        String port=scanner.nextLine();
        new SpringApplicationBuilder(PoliceApp.class)
                .web(true)
                .properties("server.port="+port)
                .run(args);
    }
}
