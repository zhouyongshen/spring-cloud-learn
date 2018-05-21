package com.zys.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class MyController {

    @MyLoadBalanced
    @Bean
    RestTemplate tplA(){
        return new RestTemplate();
    }

    @MyLoadBalanced
    @Bean
    RestTemplate tplB(){
        return new RestTemplate();
    }

    @GetMapping("call")
    public String call(){
        RestTemplate tpl=tplA();
        String json=tpl.getForObject("http://hello-service/call/1",String.class);
        return json;
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

}
