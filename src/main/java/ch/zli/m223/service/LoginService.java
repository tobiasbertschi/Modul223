package ch.zli.m223.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.LoginDaten;
import ch.zli.m223.model.User;

import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class LoginService {

    @Inject
    UserService userService;

    public Response authenticate(LoginDaten loginDaten) {
        Optional<User> user = userService.findByEmail(loginDaten.getEmail());

        try {
            if (user.isPresent() && user.get().getPasswort().equals(loginDaten.getPasswort())) {
                String token = Jwt
                        .issuer("https://zli.example.com/")
                        .upn(loginDaten.getEmail())
                        .groups(new HashSet<>(Arrays.asList("Mitglied", "Admin")))
                        .expiresIn(Duration.ofHours(24))
                        .sign();
                return Response
                        .ok(user.get())
                        .cookie(new NewCookie("coworkingspace", token))
                        .header("Authorization", "Bearer " + token)
                        .build();
            }
        } catch (Exception e) {
            System.err.println("Passwort konnte nicht validiert werden.");
        }

        return Response.status(Response.Status.FORBIDDEN).build();
    }

}