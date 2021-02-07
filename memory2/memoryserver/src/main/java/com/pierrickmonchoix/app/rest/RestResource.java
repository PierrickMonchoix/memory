package com.pierrickmonchoix.app.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pierrickmonchoix.app.Message;

/**
 * @author Mickael BARON (baron.mickael@gmail.com)
 */
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class RestResource {

    @Path("/meteo")
    @GET
    public Message getHelloWorld() {
        Message message = new Message("hey !!!!!", 42);
        return message;
    }
}