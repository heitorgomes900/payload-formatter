package com.github.heitorgomes900.payloadFormatter.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.heitorgomes900.payloadFormatter.EntryPayload;
import com.github.heitorgomes900.payloadFormatter.services.ExampleService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PayloadFormatterRest {

    @Inject
    ExampleService service;

    @POST
    @Path("/")
    public Response hello(EntryPayload entryPayload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(entryPayload);
        String teste = "br.com.bb.ebb.DadosDeTeste.op987654v1";

        return Response.ok(service.processPayload(teste)).build();
    }

    @POST
    @Path("/opa")
    public Response opa(){
        return Response.ok("opa").build();
    }
}
