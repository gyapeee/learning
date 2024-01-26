package reastassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class HttpPostMethodTest {

    public static final String AUTH_PAYLOAD = new JSONObject()
        .put("username", "admin")
        .put("password", "password123")
        .toString();

    @Test
    public void authToken() {
        //@formatter:off
        Response response = given()
            .baseUri(Globals.RESTFUL_BROKER_BASE_URL)
            .contentType(ContentType.JSON)
            .body(AUTH_PAYLOAD)
        .when()
            .post("/auth")
        .then()
            .log().all()
            .extract().response();

        //@formatter:off
        String token = response.jsonPath().getString("token");
        Assertions.assertNotEquals("",token);
    }
}
