package com.zys.spring;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.client.http.RestClient;

import java.util.ArrayList;
import java.util.List;


public class RibbonClient {
    //RibbonClient 需要在eclipse工具下运行，在IDEA下不能正确运行，原因未知。
    public static void main(String[] args)throws Exception{
    	 ConfigurationManager.getConfigInstance().setProperty(
                 "my-client.ribbon.listOfServers", "http://127.0.0.1:8010,http://127.0.0.1:8011");
    	 ConfigurationManager.getConfigInstance().setProperty(
                 "my-client.ribbon .NFLoadBalancerRuleClassName", MyRule.class.getName());
         RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
         HttpRequest request = HttpRequest.newBuilder().uri("/person/1").build();
         for(int i = 0; i < 10; i++) {
             HttpResponse response = client.executeWithLoadBalancer(request);
             String json = response.getEntity(String.class);
             System.out.println(json);
         }
    }
}
