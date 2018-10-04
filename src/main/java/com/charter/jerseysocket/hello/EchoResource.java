package com.charter.jerseysocket.hello;

import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("echo")
public class EchoResource {
    private static final Logger logger = Logger.getLogger(EchoResource.class);

    @GET
    @Produces("text/plain")
    public String echo(@QueryParam("m") String message) {
        return "echo: " + message;
    }
}

