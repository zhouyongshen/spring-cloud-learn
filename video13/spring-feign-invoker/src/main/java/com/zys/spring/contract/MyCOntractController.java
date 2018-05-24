package com.zys.spring.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
public class MyCOntractController {

    @Autowired
    private MyClient myClient;

    @GetMapping("/contract")
    public String hello(){
        return myClient.hello();
    }
}
