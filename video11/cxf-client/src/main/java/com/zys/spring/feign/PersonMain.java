package com.zys.spring.feign;

import feign.Feign;
import feign.gson.GsonDecoder;

public class PersonMain {
    public static void main(String[] args) {
        HelloClient client= Feign.builder()
                .decoder(new GsonDecoder())
                .target(HelloClient.class,"http://127.0.0.1:8080");
        Person person=client.getPerson(1);
        System.out.println(person);
    }
}
