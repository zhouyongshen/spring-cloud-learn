package com.zys.spring.jaxrs;

import feign.Feign;
import feign.jaxrs.JAXRSContract;

public class HelloMain {
    public static void main(String[] args) {
        RsCLient client= Feign.builder()
                .contract(new JAXRSContract())
                .target(RsCLient.class,"http://127.0.0.1:8080");
        String res=client.hello();
        System.out.println(res);

    }
}
