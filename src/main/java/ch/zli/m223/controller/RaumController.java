package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
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

import ch.zli.m223.model.Raum;
import ch.zli.m223.service.RaumService;

@Path("raum/")
public class RaumController {

    @Inject
    RaumService raumService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Alle Räume.", description = "Gibt eine Liste aller Räume zurück..")
    public List<Raum> index() {
        return raumService.findAll();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Ein Raum.", description = "Gibt einen Raum zurück.")
    public Raum find(@PathParam("id") Long id) {
        return raumService.findRaum(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Raum erstellen.", description = "Erstellt eine neue Raum.")
    @PermitAll
    public Raum create(Raum raum) {
        return raumService.createRaum(raum);
    }

    @Path("/{id}")
    @PUT
    @Operation(summary = "Updates an user.", description = "Updates an user by its id.")
    public Raum update(@PathParam("id") Long id, Raum raum) {
        return raumService.updateUser(id, raum);
    }

    @Path("/{id}")
    @DELETE
    @Operation(summary = "Raum löschen.", description = "Löscht einen Raum anhand der Id.")
    public void delete(@PathParam("id") Long id) {
        raumService.deleteRaum(id);
    }

}