package com.zys.spring;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("spring-feign-provider")
public interface HelloClient {

    @GetMapping("/call/{id}")
    Police call(@PathVariable("id") Integer id);

    @GetMapping("/hello")
    String hello();
}
