package reastassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class HttpDeleteMethodTest extends TestBase {

    @Test
    public void deleteBooking() {
        String token = HttpPostMethodTest.getAuthToken();
        int bookingId = HttpPostMethodTest.getBookingIdOfNewlyCreatedBooking();

        //@formatter:off
        given()
            .baseUri(Globals.RESTFUL_BROKER_BASE_URL)
            .contentType(ContentType.JSON)
            .cookie("token", token)
        .when()
            .delete(Globals.BOOKING_PATH + "/" + bookingId)
        .then().log().all()
            .assertThat()
            .statusCode(201).extract().response();
        //@formatter:on

        Response response = HttpGetMethodTest.getBooking(bookingId);

        Assertions.assertEquals(HttpStatus.SC_NOT_FOUND, response.statusCode());
    }
}
