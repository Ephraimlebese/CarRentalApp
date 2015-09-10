package za.ac.cput.carRentalApp.config;

import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Car;

import java.util.List;


/**
 * Created by student on 2015/04/27.
 */
public class BookingFactory {
    public static Booking createBooking(String date, List<Car> cars){
        Booking booking = new Booking
                .Builder(date)
                .cars(cars)
                .build();
        return booking;
    }
}
