package com.zys.spring.profileconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan("com.zys.spring.profileconfig")
public class ProfileApp {
    public static void main(String[] args) {

        new SpringApplicationBuilder(ProfileApp.class)
                .properties("spring.profiles.active = dev")
                .run(args);
    }

    @Value("${pro.test}")
    private String active;

    @GetMapping("/active")
    public String getEnv(){
//        System.out.println(123);
        return active;
    }
}
