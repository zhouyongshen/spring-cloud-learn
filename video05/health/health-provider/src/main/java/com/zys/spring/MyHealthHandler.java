package com.zys.spring;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthHandler implements HealthCheckHandler {

    @Autowired
    private MyHealthIndicator indicator;

    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        Health health=indicator.health();
        Status status=health.getStatus();
        if(status.equals(Status.UP)){
            return InstanceInfo.InstanceStatus.UP;
        }else {
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
