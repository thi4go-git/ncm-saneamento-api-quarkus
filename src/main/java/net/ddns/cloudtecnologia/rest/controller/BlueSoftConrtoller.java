package net.ddns.cloudtecnologia.rest.controller;

import net.ddns.cloudtecnologia.rest.dto.BlueSoftDTO;
import net.ddns.cloudtecnologia.service.impl.BlueSoftServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BlueSoftConrtoller {

    @Inject
    private BlueSoftServiceImpl service;

    @GET
    public Response findAll(@PathParam("code") String code) {
        BlueSoftDTO dto = service.findProdutoByCode(code);
        if (dto.getTitulo() != null) {
            return Response.ok(dto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
