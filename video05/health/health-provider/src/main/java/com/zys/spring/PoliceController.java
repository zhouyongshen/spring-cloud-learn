package com.zys.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PoliceController {

    public static boolean canVistDb=true;

    @GetMapping("/db/{can}")
    public String setDb(@PathVariable("can") boolean can){
        //模拟修改数据库链接状态
        canVistDb=can;
        return "success： "+can;
    }

}
