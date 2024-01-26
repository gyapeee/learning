package reastassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reastassured.dto.BookingsDTO;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static reastassured.Globals.RESTFUL_BROKER_BASE_URL;

public class HttpGetMethodTest extends TestBase {


    public static Response getBooking(Integer id) {
        //@formatter:off
        return given()
                .baseUri(RESTFUL_BROKER_BASE_URL)
                .contentType(ContentType.JSON)
            .when()
                .get(Globals.BOOKING_PATH + (id == null ? "" : id.toString()))
            .then().log().all()
                .extract().response();
        //@formatter:on
    }

    public static Response getBooking() {
        return getBooking(null);
    }

    @Test
    public void getBookIds() {
        //@formatter:off
        ArrayList<LinkedHashMap<String, Integer>> response =
        getBooking()
            .jsonPath()
            .getJsonObject("$");
        //@formatter:on

        BookingsDTO bookings = new BookingsDTO().setBookingIds(response);

        // just for debug
        System.out.println(bookings);

        Assertions.assertNotNull(bookings.getBookingIds().get(0).get("bookingid"));
    }
}
