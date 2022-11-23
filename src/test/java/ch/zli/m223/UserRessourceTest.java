package ch.zli.m223;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.User;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.util.Date;

@QuarkusTest
public class UserRessourceTest {

    @Test
    @TestSecurity(user = "role", roles = "Admin")
    public void testGetUserEndpoint() {
        given()
                .when().get("/user")
                .then()
                .statusCode(200);

    }

    @Test
    @TestSecurity(user = "role", roles = "Mitglied")
    public void testIndexByIdEndpoint() {

        var user = new User();
        user.setVorname("Loris");
        user.setNachname("Müller");
        user.setGeburtsdatum(new Date(2004 - 12 - 15));
        user.setEmail("loris.mueller@lernende.bbw.ch");
        user.setPasswort("lorismueller");
        user.setAdmin(false);

        var createResponse = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/user");

        given()
                .when().get("/user/" + createResponse.jsonPath().get("id"))
                .then()
                .statusCode(403);
    }

    @Test
    public void testCreateUserEndpoint() {

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

}