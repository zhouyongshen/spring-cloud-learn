package com.zys.spring.contract;

import feign.Contract;
import feign.MethodMetadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyContract extends Contract.BaseContract {
    protected void processAnnotationOnClass(MethodMetadata methodMetadata, Class<?> aClass) {

    }

    protected void processAnnotationOnMethod(MethodMetadata methodMetadata, Annotation annotation, Method method) {
        if(MyUrl.class.isInstance(annotation)){
            MyUrl myUrl=method.getAnnotation(MyUrl.class);
            String url=myUrl.url();
            String httpMethod=myUrl.method();
            methodMetadata.template().method(httpMethod).append(url);
        }
    }

    protected boolean processAnnotationsOnParameter(MethodMetadata methodMetadata, Annotation[] annotations, int i) {
        return false;
    }
}
