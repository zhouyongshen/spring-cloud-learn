package com.zys.spring.command;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.TimeUnit;

public class OpenMain {
    public static void main(String[] args) throws InterruptedException {
        //10秒内有10个请求 满足第一个条件
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.circuitBreaker.requestVolumeThreshold"
                ,"10"
        );
        for(int i=1;i<15;i++){
            RunCommand c=new RunCommand();
            String result=c.execute();
            System.out.println(i+" "+c.isCircuitBreakerOpen()+"--"+result);
            if(c.isCircuitBreakerOpen()){
                TimeUnit.SECONDS.sleep(4);
            }
        }

    }

    static class RunCommand extends HystrixCommand<String> {

        protected RunCommand() {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("testRunCommand")).andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(500)
            ));
        }

        protected String run() throws Exception {
            //测试 当短路器打开时 直接返回success
//            if(isCircuitBreakerOpen())
//                return "success";
            TimeUnit.SECONDS.sleep(1);
            return "success";
        }

        @Override
        protected String getFallback() {

            return "fallback";
        }
    }
}
