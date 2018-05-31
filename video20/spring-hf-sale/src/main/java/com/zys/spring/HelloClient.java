package com.zys.spring;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="spring-hf-member",fallback = HelloClientFallback.class)
public interface HelloClient {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/tmout")
    String timeout();
}
