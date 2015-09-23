package za.ac.cput.carRentalApp.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.cput.carRentalApp.config.CarFactory;
import za.ac.cput.carRentalApp.domain.Car;

/**
 * Created by student on 2015/08/04.
 */
//@SpringApplicationConfiguration(classes= App.class)
//@WebAppConfiguration
public class CarRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    CarRepo carRepo;

   // @Test
    public void testCreate() throws Exception {
        Car car = CarFactory.createCar("Sedan", 12000);
        carRepo.save(car);
        id = car.getId();
        Assert.assertNotNull(car.getId());
    }

   // @Test (dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        Car car = carRepo.findOne(id);
        Assert.assertNotNull(car);
        Assert.assertEquals("Sedan",car.getCategory());
    }

    //@Test (dependsOnMethods = {"testRead"})
    public void testUpdate() throws Exception {
        Car car = carRepo.findOne(id);
        Car newCar = new Car.Builder(car.getCategory()).copy(car).KM(1111).build();
        carRepo.save(newCar);

        Car updatedCar = carRepo.findOne(id);
        Assert.assertEquals(1111,updatedCar.getKM());
    }

    //@Test (dependsOnMethods = {"testUpdate"})
    public void testDelete() throws Exception {
        Car car = carRepo.findOne(id);
        carRepo.delete(car);
        Car deletedCar = carRepo.findOne(id);
        Assert.assertNull(deletedCar);
    }
}
