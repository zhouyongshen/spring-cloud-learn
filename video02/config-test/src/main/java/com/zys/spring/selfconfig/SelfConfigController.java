package com.zys.spring.selfconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

//    @Value("${abc}")
//    private String abc;
//
//    @GetMapping("abcPro")
//    public String getAbcPro(){
//        return abc;
//    }

    @Value("${abc.yml}")
    private String yml;

    @GetMapping("abcYml")
    public String getYml(){
        return yml;

    }

}
