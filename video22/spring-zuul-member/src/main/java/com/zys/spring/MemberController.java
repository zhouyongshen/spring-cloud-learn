package com.zys.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Configuration
public class MemberController {

    @GetMapping("/member")
    public Member member(HttpServletRequest request){
        return new Member("zhangsan","11",request.getRequestURL().toString());
    }
}
