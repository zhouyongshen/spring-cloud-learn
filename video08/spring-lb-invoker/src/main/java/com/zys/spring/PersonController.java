package com.zys.spring;

import com.netflix.loadbalancer.ILoadBalancer;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class PersonController {

    @Autowired
//    @LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient client;


    @GetMapping("route")
    public String route(){
        String str=restTemplate.getForObject("http://spring-lb-provider/call/1",String.class);
        return str;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("lb")
    public ServiceInstance lb(){
        ServiceInstance sit=client.choose("spring-lb-provider");
        return sit;
    }


    @Autowired
    private SpringClientFactory factory;

    @GetMapping("factory")
    public String factory(){
        ILoadBalancer lb=factory.getLoadBalancer("default");

        System.out.println(lb.getClass().getName());
        return lb.getClass().getName();
    }

}
