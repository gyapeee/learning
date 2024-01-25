package reastassured;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reastassured.dto.BookingsDTO;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static reastassured.Globals.CONTENT_TYPE_JSON;
import static reastassured.Globals.PING_ENDPOINT;
import static reastassured.Globals.RESTFUL_BROKER_BASE_URL;

public class HttpGetMethod {

    @BeforeEach
    public void verifyHealthCheck() {
        //@formatter:off
        Response response = given()
            .baseUri(RESTFUL_BROKER_BASE_URL)
            .contentType(CONTENT_TYPE_JSON)
        .when()
            .get(PING_ENDPOINT)
        .then()
            .extract()
                .response();

    Assertions.assertEquals(response.getStatusCode() ,HttpURLConnection.HTTP_CREATED);
        //@formatter:on
    }


    @Test
    public void getBookIds() {
        //@formatter:off
        ArrayList<LinkedHashMap<String, Integer>> response =
        given()
            .baseUri(RESTFUL_BROKER_BASE_URL)
            .contentType(CONTENT_TYPE_JSON)
        .when()
            .get("/booking")
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
