package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.Platz;
import ch.zli.m223.service.PlatzService;

@Path("platz/")
@RolesAllowed("Admin")
public class PlatzController {

    @Inject
    PlatzService platzService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Alle Räume.", description = "Gibt eine Liste aller Räume zurück..")
    public List<Platz> index() {
        return platzService.findAll();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Ein platz.", description = "Gibt einen platz zurück.")
    public Platz find(@PathParam("id") Long id) {
        return platzService.findPlatz(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "platz erstellen.", description = "Erstellt eine neue platz.")
    @PermitAll
    public Platz create(Platz platz) {
        return platzService.createPlatz(platz);
    }

    @Path("/{id}")
    @PUT
    @Operation(summary = "Updates an user.", description = "Updates an user by its id.")
    public Platz update(@PathParam("id") Long id, Platz platz) {
        return platzService.updatePlatz(id, platz);
    }

    @Path("/{id}")
    @DELETE
    @Operation(summary = "platz löschen.", description = "Löscht einen platz anhand der Id.")
    public void delete(@PathParam("id") Long id) {
        platzService.deletePlatz(id);
    }

}