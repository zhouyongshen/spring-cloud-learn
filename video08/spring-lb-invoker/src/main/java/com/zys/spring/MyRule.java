package com.zys.spring;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class MyRule implements IRule {


    private ILoadBalancer lb;


    public Server choose(Object o) {
        System.out.println("这是自定义的规则");
        Random random=new Random();
        int num= random.nextInt(10);
        List<Server> servers=lb.getAllServers();
        if(num>7){
            return getServerPort(servers,8010);
        }
        return getServerPort(servers,8011);
    }

    private Server getServerPort(List<Server> servers,int port){
        for(Server server:servers){
            if(server.getPort()==port){
                return server;
            }
        }
        return null;
    }

    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.lb=iLoadBalancer;
    }

    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
