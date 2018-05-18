package com.zys.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoliceController {

    @GetMapping("/call/{id}")
    public Police call(@PathVariable("id") Integer id){
        return new Police(id,"zys",11);
    }

}
