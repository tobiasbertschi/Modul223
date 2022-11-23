package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.Buchung;
import ch.zli.m223.service.BuchungService;

@Path("buchung/")
public class BuchungController {

    @Inject
    BuchungService buchungService;

    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Alle Buchungen.", description = "Gibt eine Liste aller Buchungen zurück..")
    public List<Buchung> index() {
        return buchungService.findAll();
    }

    @RolesAllowed({ "Mitglied", "Admin" })
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Eine Buchung.", description = "Gibt eine Buchung zurück.")
    public Buchung find(@PathParam("id") Long id) {
        return buchungService.findBuchung(id);
    }

    @RolesAllowed({ "Mitglied", "Admin" })
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Buchung erstellen.", description = "Erstellt eine neue Buchung.")
    public Buchung create(Buchung buchung) {
        return buchungService.createBuchung(buchung);
    }

    @RolesAllowed({ "Mitglied", "Admin" })
    @Path("/{id}")
    @DELETE
    @Operation(summary = "Buchung löschen.", description = "Löscht eine Buchung anhand der Id.")
    public void delete(@PathParam("id") Long id) {
        buchungService.deleteBuchung(id);
    }

}