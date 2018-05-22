package com.zys.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerSon(@PathVariable("id") Integer id) {
        Person person = new Person(id, "zhangsan", 22);
        return person;
    }


    @RequestMapping(value = "/person/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPerSon(@RequestBody Person p) {
        System.out.println(p.getName()+"---"+p.getAge());
        return "success,id:"+p.getId();
    }


}
