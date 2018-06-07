package com.zys.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SaleController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/food-sale")
    public Member call(){
        System.out.println("请求前。。。");
        Member member=memberService.member();
        System.out.println("请求后。。。");
        return member;
    }

}
