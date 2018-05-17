package com.zys.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelfConfigController {

    @Autowired
    private SelfConfig config;

    @GetMapping("/project")
    public String getProp(){
        return config.getName()+" - "+config.getVersion();
    }
}
