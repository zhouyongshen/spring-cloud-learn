package com.zys.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MemberController {

    @GetMapping("/member/{id}")
    public Member call(@PathVariable("id") Integer id, HttpServletRequest request){
        System.out.println("调用会员模块 获取会员信息");
        Member member=new Member(id,"zys",11);
        member.setMsg(request.getRequestURL().toString());
        return member;
    }

}
