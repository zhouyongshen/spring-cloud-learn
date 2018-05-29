package com.zys.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class SaleController {

    @Autowired
    private MemberService memberService;


    @GetMapping("router")
    public Member route(){
        Member member=memberService.getMember(1);
        return member;
    }



}
