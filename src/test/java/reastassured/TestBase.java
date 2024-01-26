package reastassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.net.HttpURLConnection;

import static io.restassured.RestAssured.given;
import static reastassured.Globals.PING_PATH;
import static reastassured.Globals.RESTFUL_BROKER_BASE_URL;

public class TestBase {
    @BeforeEach
    public void verifyHealthCheck() {
        //@formatter:off
        Response response =
            given()
                .baseUri(RESTFUL_BROKER_BASE_URL)
                .contentType(ContentType.JSON)
            .when()
                .get(PING_PATH)
            .then().log().all()
                .extract().response();

        Assertions.assertEquals(response.getStatusCode() ,HttpURLConnection.HTTP_CREATED);
        //@formatter:on
    }
}
