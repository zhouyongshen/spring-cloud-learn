package com.zys.spring;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientTest {
    public static void main(String[] args)throws IOException {
        HttpClient client= HttpClients.createDefault();
        HttpGet httpGet;
        HttpResponse response;
        for(int i=0;i<6;i++){
            httpGet=new HttpGet("http://127.0.0.1:8081/route");
            response=client.execute(httpGet);
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }
}
