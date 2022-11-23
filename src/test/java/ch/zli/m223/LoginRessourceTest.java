package ch.zli.m223;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.User;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class LoginRessourceTest {

    @Test
    @TestSecurity(user = "role", roles = "Admin")
    public void testRegistrierenEndpoint() {

        var user = new User();
        user.setVorname("Loris");
        user.setNachname("Müller");
        user.setGeburtsdatum(new Date(2004 - 12 - 15));
        user.setEmail("loris.mueller@lernende.bbw.ch");
        user.setPasswort("lorismueller");
        user.setAdmin(false);

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/user")
                .then()
                .statusCode(200);

    }

    @Test
    @TestSecurity(user = "role", roles = "Admin")
    public void testLoginEndpoint() {

        given()
                .contentType(ContentType.JSON)
                .body("{\"email\":\"gotteron89tb@gmail.com\",\"passwort\":\"tobiasbertschi\"}")
                .when().post("/login")
                .then()
                .statusCode(200);

    }

    @Test
    @TestSecurity(user = "role", roles = "Admin")
    public void testLoginFailEndpoint() {

        given()
                .contentType(ContentType.JSON)
                .body("{\"email\":\"test@tester.com\",\"passwort\":\"testtester\"}")
                .when().post("/login")
                .then()
                .statusCode(403);

    }

}