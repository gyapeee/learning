package reastassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class HttpPutMethodTest extends TestBase {

    public static final String PUT_PAYLOAD = new JSONObject()
        .put("firstname", "David")
        .put("lastname", "Kormos")
        .put("totalprice", 6969)
        .put("depositpaid", true)
        .put("bookingdates", new JSONObject()
            .put("checkin", "2002-02-20")
            .put("checkout", "2022-02-22")
        )
        .put("additionalneeds", "Lunch").toString();


    @Test
    public void updateBooking() {
        int bookingId = HttpPostMethodTest.getBookingId();
        String accessToken = HttpPostMethodTest.getAuthToken();

        //@formatter:off
        Response response = given()
            .baseUri(Globals.RESTFUL_BROKER_BASE_URL)
            .contentType(ContentType.JSON)
            .cookie("token", accessToken)
            .body(PUT_PAYLOAD)
            .log().all()
        .when()
            .put("/booking/"+bookingId)
        .then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .extract().response();
        //@formatter:on

        Assertions.assertEquals(6969, response.jsonPath().getInt("totalprice"));
    }

}
