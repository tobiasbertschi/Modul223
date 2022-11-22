package ch.zli.m223.controller;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.LoginDaten;
import ch.zli.m223.service.LoginService;

@Path("/login")
@PermitAll
public class LoginController {

    @Inject
    LoginService loginService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Authenticate a user.", description = "Returns a token upon successful authentication.")
    public Response create(@Valid LoginDaten loginDaten) {
        return this.loginService.authenticate(loginDaten);
    }

}