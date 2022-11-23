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

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import ch.zli.m223.model.User;
import ch.zli.m223.service.UserService;

@Path("user/")
public class UserController {

    @Inject
    UserService userService;

    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all users.", description = "Returns a list of all users.")
    public List<User> index() {
        return userService.findAll();
    }

    @RolesAllowed("Admin")
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index one user.", description = "Returns one user")
    public User find(@PathParam("id") Long id) {
        return userService.findUser(id);
    }

    @PermitAll
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new user. Also known as registration.", description = "Creates a new user and returns the newly added user.")
    public User create(User user) {
        return userService.createUser(user);
    }

    @RolesAllowed("Admin")
    @Path("/{id}")
    @DELETE
    @Operation(summary = "Deletes an user.", description = "Deletes an user by its id.")
    public void delete(@PathParam("id") Long id) {
        userService.deleteUser(id);
    }

    @RolesAllowed("Admin")
    @Path("/{id}")
    @PUT
    @Operation(summary = "Updates an user.", description = "Updates an user by its id.")
    public User update(@PathParam("id") Long id, User user) {
        return userService.updateUser(id, user);
    }

}