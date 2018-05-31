package com.zys.spring;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CacheService {

    @Autowired
    private RestTemplate restTemplate;

    public Member fallbackMethod(Integer id){
        Member member=new Member();
        return member;
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod",commandKey = "cache")
    @CacheResult
    public Member cacheMember(Integer id){
        Member member=restTemplate.getForObject("http://spring-hy-member/member/{id}",Member.class,id);
        return member;
    }
    @HystrixCommand
    @CacheRemove(commandKey = "cache")
    public void removeCacheMember(Integer id){
        System.out.println("删除缓存。。。。");
    }

}
