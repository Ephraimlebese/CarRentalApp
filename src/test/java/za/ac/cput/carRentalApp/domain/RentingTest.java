package za.ac.cput.carRentalApp.domain;


import org.junit.Assert;
import za.ac.cput.carRentalApp.config.RentingFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public class RentingTest {
    //@Before
    public void setUp() throws Exception {


    }

    //@Test
    public void createRentingTest() throws Exception {
        List<Booking> bookings = new ArrayList<Booking>();

        Renting renting = RentingFactory.createRenting("CA120","10",bookings);

        Assert.assertEquals("CA120", renting.getLecensePlate());

    }

   // @Test
    public void updateRentingTest() throws Exception {
        List<Booking> bookings = new ArrayList<Booking>();

        Renting renting = RentingFactory.createRenting("CA120","10",bookings);

        Renting newRenting = new Renting.Builder(renting.getLecensePlate()).copy(renting).period("1").build();

        Assert.assertEquals("1", newRenting.getPeriod());

    }

    //@After
    public void tearDown() throws Exception {


    }
}
