package com.zys.spring.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

public class MyFilter extends ZuulFilter {
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    public int filterOrder() {
        return 1;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        System.out.println("##############执行 MyFilter过滤器");
        return null;
    }
}
