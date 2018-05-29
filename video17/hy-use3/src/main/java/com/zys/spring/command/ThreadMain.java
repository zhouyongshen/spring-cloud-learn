package com.zys.spring.command;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

public class ThreadMain {
    public static void main(String[] args) throws Exception {
        //线程池
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.isolation.strategy", HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE);
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.isolation.semaphore.maxConcurrentRequests", 2);

        for (int i = 1; i <= 6; ++i) {
            final  int index=i;
            new Thread(){
                @Override
                public void run() {
                    new MyCommand(index).execute();
                }
            }.start();
        }
        TimeUnit.SECONDS.sleep(5);
    }
}
