package com.zys.spring;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CacheFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CacheFilter has done");
        HystrixRequestContext ctx = HystrixRequestContext.initializeContext();
        filterChain.doFilter(servletRequest,servletResponse);
        ctx.shutdown();
    }

    public void destroy() {

    }
}
