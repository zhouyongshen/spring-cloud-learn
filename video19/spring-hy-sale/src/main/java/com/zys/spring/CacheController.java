package com.zys.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
public class CacheController {
    
    private static final Logger log= LoggerFactory.getLogger(CacheController.class);

    @Autowired
    private CacheService cacheService;


    @GetMapping("/cache")
    public Member cache(){
        log.info("调用销售模块");
        Member member= cacheService.cacheMember(1);
        member.setMsg("自己重新写入的消息");
        log.info("第二次调用");
        Member member2= cacheService.cacheMember(1);
        log.info("两次获取到的结果是否相同："+(member==member2));
        return member;
    }

    @GetMapping("/rc")
    public Member removeCache(){
        log.info("调用销售模块");
        Member member= cacheService.cacheMember(1);
        member.setMsg("自己重新写入的消息");
        log.info("第二次调用");
        Member member2= cacheService.cacheMember(1);
        log.info("两次获取到的结果是否相同："+(member==member2));
        log.info("第三次调用");
        cacheService.removeCacheMember(1);
        Member member3= cacheService.cacheMember(1);
        log.info("两次获取到的结果是否相同："+(member==member3));
        return member;
    }





}
