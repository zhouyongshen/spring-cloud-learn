package com.zys.spring;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class PersonController {

    @Autowired
    private HelloClient helloClient;

    @GetMapping("hel")
    public String hello(){
        return helloClient.hello();
    }
    @GetMapping("pli")
    public String ploice(){
        Police p=helloClient.call(1);
        return JSONObject.toJSONString(p);
    }
}
