package com.zys.spring.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class MyInterceptor implements RequestInterceptor{
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("这是请求拦截器");

    }
}
