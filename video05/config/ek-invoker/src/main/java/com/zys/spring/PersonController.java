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
//    @LoadBalanced
    private RestTemplate restTemplate;


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("route")
    public String route() {
        String str = restTemplate.getForObject("http://cloud-police/call/1", String.class);
        return str;
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/list")
    public String serviceCount() {
        List<String> names = discoveryClient.getServices();
        for (String serviceId : names) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            System.out.println(serviceId + " : " + instances.size());
        }
        return "success";
    }

    @GetMapping("/meta")
    public String getMetadata() {
        List<ServiceInstance> instances = discoveryClient.getInstances("ek-provider");
        for(ServiceInstance instance:instances){
            String name=instance.getMetadata().get("company-name");
            System.out.println(name);
        }
        return "success";
    }

}
