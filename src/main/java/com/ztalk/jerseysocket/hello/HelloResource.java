package com.ztalk.jerseysocket.hello;

import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("hello")
public class HelloResource {
    private static final Logger logger = Logger.getLogger(HelloResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHelloText(@QueryParam("m") String message) {
        logger.debug("sayHelloText()::sample debug message::"+message);
        logger.info("sayHelloText()::sample info message::"+message);
        logger.warn("sayHelloText()::sample warning message::"+message);
        logger.error("sayHelloText()::sample error message::"+message);
        return "Hello Jersey Websocket\nJersey Websocket is cool" + message;
    }
    // This method is called if XMLis request
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Hello sayHelloJSON(@QueryParam("m") String message) {
        logger.debug("sayHelloJSON()::sample debug message::"+message);
        logger.info("sayHelloJSON()::sample info message::"+message);
        logger.warn("sayHelloJSON()::sample warning message::"+message);
        logger.error("sayHelloJSON()::sample error message::"+message);
        Hello hello = new Hello();
        hello.setSummary("Hello Jersey Websocket");
        hello.setDescription("Jersey Websocket is cool!! " + message);
        return hello;
    }

    // This can be used to test the integration with the browser
    @GET
    @Produces({ MediaType.TEXT_XML })
    public Hello sayHelloHTML(@QueryParam("m") String message) {
        logger.debug("sayHelloHTML()::sample debug message::"+message);
        logger.info("sayHelloHTML()::sample info message::"+message);
        logger.warn("sayHelloHTML()::sample warning message::"+message);
        logger.error("sayHelloHTML()::sample error message::"+message);
        Hello hello = new Hello();
        hello.setSummary("Hello Jersey Websocket");
        hello.setDescription("Jersey Websocket is cool!! " + message);
        return hello;
    }
}
