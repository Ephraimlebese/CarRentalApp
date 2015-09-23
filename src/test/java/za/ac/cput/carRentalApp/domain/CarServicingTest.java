package za.ac.cput.carRentalApp.domain;

import org.junit.Assert;
import za.ac.cput.carRentalApp.config.CarServicesFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public class CarServicingTest {
    //@Before
    public void setUp() throws Exception {


    }

    //@Test
    public void createServicesTest() throws Exception {
        List<Booking> bookings = new ArrayList<Booking>();
        List<Car> cars = new ArrayList<Car>();

        CarServicing carServicing = CarServicesFactory.createServices(12.01 , "Engine kit",bookings, cars);

        Assert.assertEquals("Engine kit",carServicing.getParts());

    }

    //@Test
    public void updateServicesTest() throws Exception {

        List<Booking> bookings = new ArrayList<Booking>();
        List<Car> cars = new ArrayList<Car>();

        CarServicing carServicing = CarServicesFactory.createServices(12.01 , "Engine kit",bookings, cars);

        CarServicing newCarServicing = new CarServicing.Builder(carServicing.getamount()).copy(carServicing).parts("gear box").build();

        Assert.assertEquals("gear box",newCarServicing.getParts());


    }
}
