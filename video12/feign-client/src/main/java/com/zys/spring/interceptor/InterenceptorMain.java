package com.zys.spring.interceptor;

import com.zys.spring.jaxrs.RsCLient;
import feign.Feign;
import feign.jaxrs.JAXRSContract;

public class InterenceptorMain {
    public static void main(String[] args) {
        RsCLient client= Feign.builder()
                .requestInterceptor(new MyInterceptor())
                .contract(new JAXRSContract())
                .target(RsCLient.class,"http://127.0.0.1:8080");
        String res=client.hello();
        System.out.println(res);
    }
}
