package com.zys.spring.feign;

import feign.Client;
import feign.Request;
import feign.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;

public class MyClient implements Client {
    /**
     * 从本质上来讲其实就是讲 feign的request转化为httpclient的request http请求后将httpclient的response转化为
     * feign需要的response
     */
    public Response execute(Request request, Request.Options options) throws IOException {
        System.out.println("this is my client");
        try {

            CloseableHttpClient client = HttpClients.createDefault();
            final String method = request.method();

            HttpRequestBase httpRequest = new HttpRequestBase() {
                public String getMethod() {
                    return method;
                }
            };
            httpRequest.setURI(new URI(request.url()));

            HttpResponse httpResponse = client.execute(httpRequest);
            byte[] body = EntityUtils.toByteArray(httpResponse.getEntity());
            Response response = Response.builder().body(body).headers(new HashMap<String, Collection<String>>()).status(httpResponse.getStatusLine().getStatusCode()).build();
            return response;


        } catch (Exception e) {

        }
        return null;
    }
}
