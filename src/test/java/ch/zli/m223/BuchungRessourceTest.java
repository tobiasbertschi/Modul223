package ch.zli.m223;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.Buchung;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.util.Date;

@QuarkusTest
public class BuchungRessourceTest {

    @Test
    @TestSecurity(user = "role", roles = "Mitglied")
    public void testGetBuchungEndpoint() {
        given()
                .when().get("/buchung")
                .then()
                .statusCode(403);
    }

    @Test
    @TestSecurity(user = "role", roles = "Admin")
    public void testPutBuchungEndpoint() {

        given()
                .contentType(ContentType.JSON)
                .body("{\"status\":\"bestätigt\",\"datum\":\"2022-12-14\",\"ganztag\":\"true\",\"notiz\":\"Test update erfolgreich\",\"user\":{\"id\":1},\"raum\":{\"id\":2}}")
                .when().put("/buchung/1")
                .then()
                .statusCode(200);
    }

    @Test
    @TestSecurity(user = "role", roles = "Admin")
    public void testDeleteBuchungEndpoint() {
        given()
                .when().delete("/buchung/1")
                .then()
                .statusCode(204);
    }

}