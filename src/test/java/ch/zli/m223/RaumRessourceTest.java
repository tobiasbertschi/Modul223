package ch.zli.m223;

import org.junit.jupiter.api.Test;
    
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class RaumRessourceTest {
    
        @Test
        @TestSecurity(user = "role", roles = "Mitglied")
        public void testGetRaumEndpoint() {
            given()
                    .when().get("/raum")
                    .then()
                    .statusCode(403);
    
        }
    
        @Test
        @TestSecurity(user = "role", roles = "Admin")
        public void testGetRaumByEndpoint() {
    
            given()
                    .when().get("/raum/2")
                    .then()
                    .statusCode(200);
        }

        @Test
        @TestSecurity(user = "role", roles = "Mitglied")
        public void testDeleteBuchungEndpoint() {
            given()
                    .when().delete("/raum/1")
                    .then()
                    .statusCode(403);
        }
    
    }