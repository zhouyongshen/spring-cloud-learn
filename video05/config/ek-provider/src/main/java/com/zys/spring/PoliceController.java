package com.zys.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PoliceController {

    @GetMapping("/call/{id}")
    public Police call(@PathVariable("id") Integer id, HttpServletRequest request){
         Police p=new Police(id,"zys",11);
         String uri=request.getRequestURL().toString();
        p.setMsg(uri);
        return p;
    }

}
