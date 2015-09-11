package za.ac.cput.carRentalApp.services;

import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.CarServicing;
import za.ac.cput.carRentalApp.domain.Customer;

import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
public interface CarServicingService extends Services<CarServicing, Long> {
    List<CarServicing> getCarServices();
    List<Booking> getBookings(Long id);
    List<Customer> getCustomer(Long id);

}
