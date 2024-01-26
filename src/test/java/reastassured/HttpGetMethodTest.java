package reastassured;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reastassured.dto.BookingsDTO;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static reastassured.Globals.RESTFUL_BROKER_BASE_URL;

public class HttpGetMethodTest extends TestBase {


    @Test
    public void getBookIds() {
        //@formatter:off
        ArrayList<LinkedHashMap<String, Integer>> response =
        given()
            .baseUri(RESTFUL_BROKER_BASE_URL)
            .contentType(ContentType.JSON)
        .when()
            .get(Globals.BOOKING_PATH)
        .then()
            .extract()
            .response()
            .jsonPath()
            .getJsonObject("$");
        //@formatter:on

        BookingsDTO bookings = new BookingsDTO().setBookingIds(response);

        // just for debug
        System.out.println(bookings);

        Assertions.assertNotNull(bookings.getBookingIds().get(0).get("bookingid"));
    }
}
