package ch.zli.m223;

import org.junit.jupiter.api.Test;
    
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class MitgliedBuchungRessourceTest {
    
        @Test
        @TestSecurity(user = "role", roles = "Mitglied")
        public void testGetMitgliedBuchungEndpoint() {
            given()
                    .when().get("/mitglied/buchung/1")
                    .then()
                    .statusCode(200);
        }
    
        @Test
        @TestSecurity(user = "role", roles = "Admin")
        public void testDeleteBuchungEndpoint() {
            given()
                    .when().delete("/mitglied/buchung/1")
                    .then()
                    .statusCode(403);
        }

        @Test
        @TestSecurity(user = "role", roles = "Mitglied")
        public void testCreateMitgliedBuchungEndpoint() {
                given()
                        .contentType(ContentType.JSON)
                        .body("{\"status\":\"angefragt\",\"datum\":\"2022-11-27\",\"ganztag\":\"false\",\"notiz\":\"\",\"user\":{\"id\":2},\"raum\":{\"id\":2}}")
                        .when().post("/mitglied/buchung/1")
                        .then()
                        .statusCode(200);
        }

    }