package com.zys.spring.command.config;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

public class GloabConfigCommand extends HystrixCommand<String> {

    public static void main(String[] args) {
        ConfigurationManager
                .getConfigInstance()
                .setProperty(
                        "hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds"
                        ,3000);
        GloabConfigCommand c=new GloabConfigCommand();
        String result=c.execute();
        System.out.println(result);
    }

    public GloabConfigCommand(){
        super(HystrixCommandGroupKey.Factory.asKey("test"));
        HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(2000);
    }

    protected String run() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return "success";
    }

    @Override
    protected String getFallback() {
        return "fall back ";
    }
}
