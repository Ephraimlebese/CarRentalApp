package za.ac.cput.carRentalApp.config;

import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Customer;
import za.ac.cput.carRentalApp.domain.Driver;
import za.ac.cput.carRentalApp.domain.Invoice;

import java.util.List;

/**
 * Created by student on 2015/04/27.
 */
public class CustomerFactory {
    public static Customer createCustomer(String firstName, String lastName,String address,List<Invoice> invoices,List<Driver> drivers,List<Booking> bookings){
        Customer customer = new Customer
                .Builder(firstName)
                .lastName(lastName)
                .address(address)
                .invoice(invoices)
                .driver(drivers)
                .booking(bookings)
                .build();
        return customer;
    }
}
