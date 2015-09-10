package za.ac.cput.carRentalApp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.carRentalApp.config.CarFactory;

/**
 * Created by student on 2015/04/26.
 */
public class CarTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void createCarTest() throws Exception {
        Car car = CarFactory.createCar("Sedan",12000);

        Assert.assertEquals("Sedan", car.getCategory());

    }

    @Test
    public void updateCarTest() throws Exception {

        Car car = CarFactory.createCar("Sedan",12000);

        Car newCar = new Car.Builder(car.getCategory()).copy(car).KM(1000).build();

        Assert.assertEquals(1000, newCar.getKM());
    }
}
