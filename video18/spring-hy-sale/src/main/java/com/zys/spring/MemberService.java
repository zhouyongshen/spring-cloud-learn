package com.zys.spring;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MemberService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public Member getMember(Integer id){
        Member member=restTemplate.getForObject("http://spring-hy-member/member/{id}",Member.class,id);
        return member;
    }

    public Member fallbackMethod(Integer id){
        Member member=new Member();
        return member;
    }

}
