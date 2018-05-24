package com.zys.spring.contract;

public interface ContractClient {
    @MyUrl(url = "hello",method ="GET")
    String hello();
}
