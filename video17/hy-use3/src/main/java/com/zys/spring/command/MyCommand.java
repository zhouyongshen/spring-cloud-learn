package com.zys.spring.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.TimeUnit;

public class MyCommand extends HystrixCommand<String> {
    private int index;
    protected MyCommand(int index) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("testGroupKey")));
        this.index=index;
    }

    protected String run() throws Exception {
        Thread.sleep(500);
        System.out.println("执行命令方法，当前索引："+index);
        return "success";
    }

    @Override
    protected String getFallback() {
        System.out.println("执行回退方法，当前索引："+index);
        return "fallback";
    }
}
