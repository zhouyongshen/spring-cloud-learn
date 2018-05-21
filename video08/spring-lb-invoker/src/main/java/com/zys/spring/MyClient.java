package com.zys.spring;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(value = "spring-lb-provider",configuration = Myconfig.class)
public class MyClient {
}
