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
    public static final String POST_PAYLOAD = new JSONObject()
        .put("firstname", "David")
        .put("lastname", "Kormos")
        .put("totalprice", 69)
        .put("depositpaid", true)
        .put("bookingdates", new JSONObject()
            .put("checkin", "2002-02-20")
            .put("checkout", "2022-02-22")
        )
        .put("additionalneeds", "Lunch").toString();

    public static String getAuthToken() {
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
        //@formatter:on

        return response.jsonPath().getString("token");
    }

    static int getBookingId() {
        //@formatter:off
        Response response = given()
            .baseUri(Globals.RESTFUL_BROKER_BASE_URL)
            .contentType(ContentType.JSON)
            .body(POST_PAYLOAD)
            //.header("Cookie", "token=" + authToken)
            .log().all()
        .when()
            .post("/booking")
        .then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .extract().response();
        //@formatter:on

        return response.jsonPath().getInt("bookingid");
    }

    @Test
    public void authToken() {
        String token = getAuthToken();
        Assertions.assertNotEquals("", token);
    }
}
