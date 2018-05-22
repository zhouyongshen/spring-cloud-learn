package com.zys.spring.feign;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class TestJsonMain {
    public static void main(String[] args) {
        HelloClient client= Feign.builder()
                .encoder(new GsonEncoder())
//                .decoder(new GsonDecoder())
                .target(HelloClient.class,"http://127.0.0.1:8080");
        Person p=new Person();
        p.setAge(33);
        p.setId(22);
        p.setName("zhangsan");
        String res=client.createPerSon(p);
        System.out.println(res);

    }
}
