package com.zys.spring.contract;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContractConfig {
    @Bean
    public Contract getMyContract(){
        return new MyContract();
    }
}
