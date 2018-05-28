package com.zys.spring.command.config;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

public class TimeOutCommand extends HystrixCommand<String> {

    public static void main(String[] args) {
        TimeOutCommand c=new TimeOutCommand();
        String result=c.execute();
        System.out.println(result);
    }

    public TimeOutCommand(){
        super(HystrixCommandGroupKey.Factory.asKey("test"));
        HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(2000);
    }

    protected String run() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        return "success";
    }

    @Override
    protected String getFallback() {
        return "fall back ";
    }
}
