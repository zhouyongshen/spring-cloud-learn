package com.zys.spring.contract;

import com.zys.spring.Police;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("spring-feign-provider")
public interface MyClient {
    //@GetMapping("/hello")
    @MyUrl(url = "/hello",method = "GET")
    String hello();
}
