package com.zys.spring;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    
    private static final Logger log= LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private HelloClient helloClient;

    @GetMapping("/hello")
    public String hello(){
        String result=helloClient.hello();
        return result;
    }
    @GetMapping("/timeout")
    public String timeout(){
        String result=helloClient.timeout();
        HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory
                .getInstance(HystrixCommandKey.Factory
                        .asKey("HelloClient#timeout()"));
        log.info("断路器的状态为：{}",breaker.isOpen());
        return result;
    }
}
