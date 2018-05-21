package com.zys.spring;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Configuration
public class MyConfig {

    @MyLoadBalanced
    @Autowired(required = false)
    private List<RestTemplate> tpls = Collections.emptyList();

    @Bean
    public String init() {
        System.out.println(tpls.size());
        for (RestTemplate tpl : tpls) {
//                    System.out.println(tpl);
            tpl.getInterceptors().add(new MyInterceptor());
        }
        return "";
    }

//    @Bean
//    public SmartInitializingSingleton lbInitializing(){
//        return new SmartInitializingSingleton() {
//            public void afterSingletonsInstantiated() {
//                System.out.println(tpls.size());
//                for(RestTemplate tpl:tpls){
////                    System.out.println(tpl);
//                    tpl.getInterceptors().add(new MyInterceptor());
//                }
//
//            }
//        };
//    }


}
