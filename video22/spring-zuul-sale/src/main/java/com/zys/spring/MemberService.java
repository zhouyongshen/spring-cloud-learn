package com.zys.spring;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("spring-zuul-member")
public interface MemberService {

    @GetMapping("/member")
    Member member();
}
