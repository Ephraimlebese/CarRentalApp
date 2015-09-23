package za.ac.cput.carRentalApp.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.cput.carRentalApp.config.BookingFactory;
import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/04.
 */
//@SpringApplicationConfiguration(classes= App.class)
//@WebAppConfiguration
public class BookingRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    BookingRepo bookingRepo;

    //@Test
    public void testCreate() throws Exception {
        List<Car> cars = new ArrayList<Car>();
        Booking booking = BookingFactory.createBooking("12May2015", cars);
        bookingRepo.save(booking);
        id = booking.getID();
        Assert.assertNotNull(booking.getID());
    }

    //@Test (dependsOnMethods = "testCreate")
    public void testRead() throws Exception {

        Booking booking = bookingRepo.findOne(id);
        Assert.assertNotNull(booking.getID());
        Assert.assertEquals("12May2015",booking.getDate());
    }

    //@Test (dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Booking booking = bookingRepo.findOne(id);
        Booking newBooking = new Booking.Builder(booking.getDate()).copy(booking).date("16July2015").build();
        bookingRepo.save(newBooking);
        Booking updateBooking = bookingRepo.findOne(id);
        Assert.assertEquals("16July2015" , updateBooking.getDate());
    }

    //@Test (dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Booking booking = bookingRepo.findOne(id);
        bookingRepo.delete(booking);
        Booking deletedBooking = bookingRepo.findOne(id);
        Assert.assertNull(deletedBooking);
    }
}
