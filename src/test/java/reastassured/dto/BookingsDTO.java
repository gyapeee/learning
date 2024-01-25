package reastassured.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BookingsDTO {
    private ArrayList<LinkedHashMap<String, Integer>> bookingIds;

    public ArrayList<LinkedHashMap<String, Integer>> getBookingIds() {
        return bookingIds;
    }

    public BookingsDTO setBookingIds(ArrayList<LinkedHashMap<String, Integer>> bookingIds) {
        this.bookingIds = bookingIds;
        return this;
    }

    @Override
    public String toString() {
        return "BookingsDTO{" +
            "bookingIds=" + bookingIds +
            '}';
    }
}
