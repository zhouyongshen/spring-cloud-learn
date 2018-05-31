package com.zys.spring;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class HelloClientFallback implements HelloClient{

    public String hello() {
        return "fallback";
    }

    public String timeout() {
        return "time out fallback";
    }
}
