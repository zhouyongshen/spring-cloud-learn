package com.zys.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultConfigController {

    @Autowired
    private ApplicationContext ctx;

    @Value("${test.user.name}")
    private String userName;

    @GetMapping("/prop")
    public String getProp(){
        return ctx.getEnvironment().getProperty("test.user.name");
    }

    @GetMapping("/name")
    public String getName(){
        return userName;
    }

}
