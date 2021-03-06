package com.zys.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MyRestController {

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerSon(@PathVariable("id") Integer id,HttpServletRequest request) {
        Person person = new Person(id, "zhangsan", 22);
        person.setMsg(request.getRequestURL().toString());
        return person;
    }

}
