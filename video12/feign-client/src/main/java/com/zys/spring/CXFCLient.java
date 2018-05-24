package com.zys.spring;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

public class CXFCLient {


    public static void main(String[] args) throws IOException {
        //创建WebClient
        WebClient client=WebClient.create("http://127.0.0.1:8080/person/1");
        //获取响应
        Response response=client.get();
        //获取相应内容
        InputStream is=(InputStream) response.getEntity();
        String content=IOUtils.readStringFromStream(is);
        //输出字符串
        System.out.println(content);



    }

}
