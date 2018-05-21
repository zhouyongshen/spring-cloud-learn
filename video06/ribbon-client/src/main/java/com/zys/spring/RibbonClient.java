package com.zys.spring;


import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.niws.client.http.RestClient;

public class RibbonClient {
    public static void main(String[] args) throws  Exception {
        //RibbonClient 需要在eclipse工具下运行，在IDEA下不能正确运行，原因未知。

        ConfigurationManager.getConfigInstance().setProperty(
                "my-client.ribbon.listOfServers", "http://127.0.0.1:8010,http://127.0.0.1:8011");
        RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
        HttpRequest request = HttpRequest.newBuilder().uri("/person/1").build();
        for(int i = 0; i < 10; i++) {
            HttpResponse response = client.executeWithLoadBalancer(request);
            String json = response.getEntity(String.class);
            System.out.println(json);
        }
    }
}
