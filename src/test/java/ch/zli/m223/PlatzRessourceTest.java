package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PlatzRessourceTest {

    @Test
    @TestSecurity(user = "role", roles = "Admin")
    public void testGetPlatzEndpoint() {
        given()
                .when().get("/platz")
                .then()
                .statusCode(200);

    }

    @Test
    @TestSecurity(user = "role", roles = "Mitglied")
    public void testCreatePlatzEndpoint() {

        given()
                .contentType(ContentType.JSON)
                .body("{\"stehpult\":\"true\",\"raum\":{\"id\":2}}")
                .when().get("/platz/")
                .then()
                .statusCode(403);
    }

    @Test
    @TestSecurity(user = "role", roles = "Admin")
    public void testDeletePlatzEndpoint() {
        given()
                .when().delete("/platz/2")
                .then()
                .statusCode(204);
    }

}