package com.zys.spring.logger;

import com.zys.spring.jaxrs.RsCLient;
import feign.Feign;
import feign.Logger;
import feign.jaxrs.JAXRSContract;

/**
 * 设置记录日志
 */
public class LoggerMain {
    public static void main(String[] args) {
        /**
         * NONE 默认值 不记录日志
         BASIC 记录请求放大，URL,响应代码和执行时间
         HEADERS  在basic的基础上记录请求头和响应头
         FULL 在header的基础上，请求和响应的元数据都会被记录
         */
        RsCLient client= Feign.builder()
                .logLevel(Logger.Level.FULL)
                .logger(new Logger.JavaLogger().appendToFile("log.log"))
                .contract(new JAXRSContract())
                .target(RsCLient.class,"http://127.0.0.1:8080");
        String res=client.hello();
        System.out.println(res);
    }
}
