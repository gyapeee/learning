package reastassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class HttpPatchMethodTest extends TestBase {
    public static final String PATCH_PAYLOAD = new JSONObject()
        .put("firstname", "Gyapi")
        .put("lastname", "").toString();

    @Test
    public void changeFirstNameAndLastName() {
        String token = HttpPostMethodTest.getAuthToken();
        int bookingId = HttpPostMethodTest.getBookingIdOfNewlyCreatedBooking();

        //@formatter:off
        Response response = given()
            .baseUri(Globals.RESTFUL_BROKER_BASE_URL)
            .contentType(ContentType.JSON)
            .cookie("token",token)
            .body(PATCH_PAYLOAD)
            .log().all()
        .when()
            .patch(Globals.BOOKING_PATH + "/" + bookingId)
        .then()
            .log().all()
            .assertThat()
            .statusCode(HttpStatus.SC_OK)
            .extract().response();
        //@formatter:on

        Assertions.assertEquals("Gyapi", response.jsonPath().getString("firstname"));
        Assertions.assertEquals("", response.jsonPath().getString("lastname"));
    }
}
