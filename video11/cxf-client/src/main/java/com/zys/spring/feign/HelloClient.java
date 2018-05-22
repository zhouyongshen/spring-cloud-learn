package com.zys.spring.feign;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface HelloClient {

    @RequestLine("GET /hello")
    String hello();

    @RequestLine("GET /person/{id}")
    Person getPerson(@Param("id") Integer id);

    @RequestLine("POST /person/create")
    @Headers("Content-Type: application/json")
    String createPerSon(Person p) ;
}
