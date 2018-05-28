package com.zys.spring.command.cb;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class FailBackMain {

    public static void main(String[] args) {
        FallBackCommand c=new FallBackCommand();
        String result=c.execute();
        System.out.println(result);
    }

    static class FallBackCommand extends HystrixCommand<String> {


        protected FallBackCommand() {
            super(
                    Setter
                            .withGroupKey(HystrixCommandGroupKey.Factory.asKey("group"))
                            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withCircuitBreakerForceOpen(true)));
        }

        protected String run() throws Exception {
            return "success";
        }

        @Override
        protected String getFallback() {
            return "fallback";
        }
    }
}
