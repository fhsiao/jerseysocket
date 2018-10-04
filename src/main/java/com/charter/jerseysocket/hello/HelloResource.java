package com.charter.jerseysocket.hello;

import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloResource {
    private static final Logger logger = Logger.getLogger(HelloResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayhello() {
        logger.debug("sample debug message");
        logger.info("sample info message");
        logger.warn("sample warning message");
        logger.error("sample error message");
        return "Hello Jersey Websocket";
    }
}
