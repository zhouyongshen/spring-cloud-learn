package com.zys.spring.contract;

import feign.Feign;

public class ContractMain {
    public static void main(String[] args) {
        ContractClient client= Feign.builder()
                .contract(new MyContract())
                .target(ContractClient.class,"http://127.0.0.1:8080");
        String res=client.hello();
        System.out.println(res);
    }
}
