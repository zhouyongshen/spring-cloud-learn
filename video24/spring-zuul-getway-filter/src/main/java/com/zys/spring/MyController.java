package com.zys.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/receive/{name}")
    public String receive(@PathVariable("name") String  name){
        return "success  "+ name;
    }
}
