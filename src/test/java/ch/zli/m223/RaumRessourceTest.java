package ch.zli.m223;

import org.junit.jupiter.api.Test;
    
import ch.zli.m223.model.User;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.util.Date;

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