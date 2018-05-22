package com.zys.spring.feign;

import feign.Param;
import feign.RequestLine;

public interface HelloClient {

    @RequestLine("GET /hello")
    String hello();

    @RequestLine("GET /person/{id}")
    Person getPerson(@Param("id") Integer id);
}
