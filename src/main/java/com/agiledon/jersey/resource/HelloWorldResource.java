package com.agiledon.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created with IntelliJ IDEA.
 * User: Zhang Yi
 * Date: 11/15/12
 * Time: 4:58 PM
 */
@Path("/helloworld")
public class HelloWorldResource {
    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello World";
    }
}
