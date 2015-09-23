package za.ac.cput.carRentalApp.domain;

import org.junit.Assert;
import za.ac.cput.carRentalApp.config.BookingFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public class BookingTest {
   // @Before
    public void setUp() throws Exception {


    }

   // @Test
    public void createBookingTest() throws Exception {
        List<Car> cars = new ArrayList<Car>();
        Booking booking = BookingFactory.createBooking("12May2015",cars);

        Assert.assertEquals("12May2015",booking.getDate());

    }

   // @Test
    public void updateBookingtest() throws Exception {

        List<Car> cars = new ArrayList<Car>();
        Booking booking = BookingFactory.createBooking("12May2015",cars);

        Booking newBooking = new Booking.Builder(booking.getDate()).copy(booking).date("15July2015").build();

        Assert.assertEquals("15July2015",newBooking.getDate());
    }
}
