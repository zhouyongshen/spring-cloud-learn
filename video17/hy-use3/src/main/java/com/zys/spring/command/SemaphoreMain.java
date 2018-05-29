package com.zys.spring.command;

import com.netflix.config.ConfigurationManager;

import java.util.concurrent.TimeUnit;

public class SemaphoreMain {
    public static void main(String[] args) throws Exception{
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.threadpool.default.coreSize",3);

        for(int i=1;i<=6;++i){
            MyCommand c=new MyCommand(i);
            c.queue();
        }
        TimeUnit.SECONDS.sleep(5);
    }
}
