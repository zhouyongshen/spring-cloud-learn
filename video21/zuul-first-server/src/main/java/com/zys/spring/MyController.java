package com.zys.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "hello  "+name;
    }

}
