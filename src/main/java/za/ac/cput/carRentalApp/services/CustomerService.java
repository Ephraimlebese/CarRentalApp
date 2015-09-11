package za.ac.cput.carRentalApp.services;

import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Customer;

import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
public interface CustomerService extends Services<Customer,Long> {
    List<Customer> getCustomers();
    List<Booking> getBookings(Long id);
    List<Customer>  updateSubject(Long id);

}
