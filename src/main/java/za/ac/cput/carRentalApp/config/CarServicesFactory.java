package za.ac.cput.carRentalApp.config;

import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Car;
import za.ac.cput.carRentalApp.domain.CarServicing;

import java.util.List;

/**
 * Created by student on 2015/05/05.
 */
public class CarServicesFactory {

    public static CarServicing createServices( Double amount, String parts,List<Booking> bookings, List<Car> cars){
        CarServicing carServicing = new CarServicing
                .Builder(amount)
                .parts(parts)
                .booking(bookings)
                .cars(cars)
                .build();
        return carServicing;
    }
}
