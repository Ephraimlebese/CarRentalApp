package za.ac.cput.carRentalApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.carRentalApp.App;
import za.ac.cput.carRentalApp.config.*;
import za.ac.cput.carRentalApp.domain.*;
import za.ac.cput.carRentalApp.repository.CustomerRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CustomerServiceTest  extends AbstractTestNGSpringContextTests {

    @Autowired
    private CustomerService customerService;
    private Long id;
    @Autowired
    CustomerRepo customerRepo;
    private List<Booking> bookings;
    private List<Driver> drivers;
    private List<Invoice> invoices;
    private List<Car> cars;

    @BeforeMethod
    public void setUp() throws Exception {
        bookings = new ArrayList<>();
        drivers = new ArrayList<>();
        invoices = new ArrayList<>();
        cars = new ArrayList<>();
    }

    @Test
    public void testCreate() throws Exception {
        Car car1 = CarFactory.createCar("Sedan", 1000);
        cars.add(car1);
        Booking booking1 = BookingFactory.createBooking("12July2015",cars);
        bookings.add(booking1);
        Driver driver1 = DriverFactory.createDriver("Code8",8);
        drivers.add(driver1);
        Invoice invoice1 = InvoiceFactory.createInvoice(12,12);
        invoices.add(invoice1);

        Customer customer = CustomerFactory.createCustomer("Thabo","Lebese","10Dorset",invoices,drivers,bookings);

        customerRepo.save(customer);

        id = customer.getID();
        Assert.assertNotNull(id);
    }

    @Test
    public void testGetBookings() throws Exception {
        List<Booking> booking = customerService.getBookings(id);
        Assert.assertTrue(booking.size() > 0);

    }

    @AfterMethod
    public void tearDown() throws Exception {


    }
}
