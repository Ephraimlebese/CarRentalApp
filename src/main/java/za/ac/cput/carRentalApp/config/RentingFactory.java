package za.ac.cput.carRentalApp.config;

import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Renting;

import java.util.List;

/**
 * Created by student on 2015/05/05.
 */
public class RentingFactory {
    public static Renting createRenting(String lecensePlate, String period, List<Booking> bookings){
        Renting renting = new Renting
                .Builder(lecensePlate)
                .period(period)
                .booking(bookings)
                .build();
        return renting;

    }
}
