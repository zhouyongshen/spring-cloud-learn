package com.zys.spring;

import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

public class RibbonClient2 {
    public static void main(String[] args) {
    	
    	//RibbonClient 需要在eclipse工具下运行，在IDEA下不能正确运行，原因未知。

        ConfigurationManager.getConfigInstance().setProperty(
                "my-client.ribbon.listOfServers", "http://127.0.0.1:8010,http://127.0.0.1:8011");
        
          
        BaseLoadBalancer lb=new BaseLoadBalancer();
        List<Server> servers=new ArrayList();
        servers.add(new Server("http://127.0.0.1",8010));
        servers.add(new Server("http://127.0.0.1",8011));
        IRule rule=new MyRule();
        lb.setRule(rule);
        rule.setLoadBalancer(lb);


        lb.addServers(servers);

        for(int i=0;i<10;i++){
            Server s=lb.chooseServer(null);
            System.out.println(s);

        }


    }
}
