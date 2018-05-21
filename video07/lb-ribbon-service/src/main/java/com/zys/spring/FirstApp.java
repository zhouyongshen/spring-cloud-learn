package com.zys.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

@SpringBootApplication
public class FirstApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("输入端口号(8010或8011)： ");
        String port=sc.nextLine();
        new SpringApplicationBuilder(FirstApp.class)
                .properties("server.port="+port)
                .run(args);

    }
}
