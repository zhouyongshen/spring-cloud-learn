package com.zys.spring.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface RsCLient {

    @GET
    @Path("/hello")
    String hello();
}
