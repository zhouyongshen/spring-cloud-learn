package com.zys.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String hello(){

        return "hello world";

    }
    @GetMapping("errorhello")
    @ResponseBody
    public String errorhello()throws InterruptedException{

        TimeUnit.SECONDS.sleep(10);

        return "hello world";

    }
}
