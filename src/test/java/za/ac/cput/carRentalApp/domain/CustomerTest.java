package za.ac.cput.carRentalApp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.carRentalApp.config.CustomerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public class CustomerTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void createCustomerTest() throws Exception {
        List<Booking> bookings = new ArrayList<Booking>();
        List<Driver> drivers = new ArrayList<Driver>();
        List<Invoice> invoices = new ArrayList<Invoice>();

        Customer customer = CustomerFactory.createCustomer("Thabo","Lebese","10 dorset Street",invoices,drivers,bookings);

        Assert.assertEquals("Lebese", customer.getLastName());

    }

    @Test
    public void updateCustomerTest() throws Exception {

        List<Booking> bookings = new ArrayList<Booking>();
        List<Driver> drivers = new ArrayList<Driver>();
        List<Invoice> invoices = new ArrayList<Invoice>();

        Customer customer = CustomerFactory.createCustomer("Thabo","Lebese","10 dorset Street",invoices,drivers,bookings);

        Customer newCustomer = new Customer.Builder(customer.getFirstName()).copy(customer).lastName("Malala").build();

        Assert.assertEquals("Malala", newCustomer.getLastName());

    }
}
