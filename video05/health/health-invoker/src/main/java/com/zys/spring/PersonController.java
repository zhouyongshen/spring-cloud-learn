package com.zys.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Configuration
public class PersonController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/list")
    public String serviceCount() {
        List<String> names = discoveryClient.getServices();
        StringBuilder sb=new StringBuilder();
        for (String serviceId : names) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            sb.append(serviceId + " : " + instances.size()+System.lineSeparator());
        }
        return sb.toString();
    }

}
