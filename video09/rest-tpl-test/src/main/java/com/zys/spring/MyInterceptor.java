package com.zys.spring;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MyInterceptor  implements ClientHttpRequestInterceptor{

    public ClientHttpResponse intercept(
            final HttpRequest request,
            byte[] bytes,
            ClientHttpRequestExecution execution
    ) throws IOException {
        System.out.println("这是自定义拦截器");
        System.out.println("      旧的uri:"+request.getURI());

        final HttpRequest myRequest=new HttpRequest() {

            public HttpMethod getMethod() {
                return request.getMethod();
            }
            public URI getURI() {
                try {
                    return new URI("http://localhost:8080/hello");
                } catch (URISyntaxException e) {
                }
                return null;
            }
            public HttpHeaders getHeaders() {
                return request.getHeaders();
            }
        };

        System.out.println("      新的uri:"+myRequest.getURI());
        return execution.execute(myRequest,bytes);
    }

}
