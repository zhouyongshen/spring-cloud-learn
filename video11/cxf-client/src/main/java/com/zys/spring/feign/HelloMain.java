package com.zys.spring.feign;

import feign.Feign;

public class HelloMain {
    public static void main(String[] args) {
        HelloClient client=Feign.builder()
                .target(HelloClient.class,"http://127.0.0.1:8080");
        String res=client.hello();
        System.out.println(res);

    }
}
