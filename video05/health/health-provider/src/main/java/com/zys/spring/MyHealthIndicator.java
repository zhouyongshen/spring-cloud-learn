package com.zys.spring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

    public Health health() {
        //模拟测试数据库的链接状态
        if(PoliceController.canVistDb){
            return new Health.Builder(Status.UP).build();
        }else {
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
