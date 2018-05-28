package com.zys.spring.command.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

public class KeyCommand extends HystrixCommand<String> {
    protected KeyCommand() {
        super(Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("groupKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("poolKey"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("commandKey"))
        );

    }

    protected String run() throws Exception {
        return null;
    }
}
