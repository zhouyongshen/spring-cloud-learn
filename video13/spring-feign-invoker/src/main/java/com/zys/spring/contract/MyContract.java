package com.zys.spring.contract;

import feign.Contract;
import feign.MethodMetadata;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyContract extends SpringMvcContract {

    protected void processAnnotationOnMethod(MethodMetadata methodMetadata, Annotation annotation, Method method) {
        super.processAnnotationOnMethod(methodMetadata,annotation,method);
        System.out.println("自定义的注解翻译器");
        if(MyUrl.class.isInstance(annotation)){
            MyUrl myUrl=method.getAnnotation(MyUrl.class);
            String url=myUrl.url();
            String httpMethod=myUrl.method();
            methodMetadata.template().method(httpMethod).append(url);
        }
    }
}
