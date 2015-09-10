package za.ac.cput.carRentalApp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Assert;
import org.testng.annotations.Test;
import za.ac.cput.carRentalApp.App;
import za.ac.cput.carRentalApp.config.CarServicesFactory;
import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Car;
import za.ac.cput.carRentalApp.domain.CarServicing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/07.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CarServicingRepoTest extends AbstractTestNGSpringContextTests {


    private Long id;

    @Autowired
    CarServicesRepo carServicingRepo;


    @Test
    public void testCreate() throws Exception {

        List<Booking> bookings = new ArrayList<Booking>();
        List<Car> cars = new ArrayList<Car>();

        CarServicing carServicing = CarServicesFactory.createServices(12.01 , "Engine kit",bookings, cars);
        carServicingRepo.save(carServicing);
        id = carServicing.getID();

        Assert.assertNotNull(carServicing.getID());

    }

    @Test  (dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        CarServicing carServicing = carServicingRepo.findOne(id);
        Assert.assertNotNull(carServicing);
        Assert.assertEquals("Engine kit", carServicing.getParts());

    }

    @Test(dependsOnMethods = {"testRead"})
    public void testUpdate() throws Exception {



        CarServicing carServicing = carServicingRepo.findOne(id);
        CarServicing newCarServicing = new CarServicing.Builder(0.00).copy(carServicing)
                .parts("GearBox")
                .build();
        carServicingRepo.save(newCarServicing);

        CarServicing updateCarServicing = carServicingRepo.findOne(id);
        Assert.assertEquals("GearBox", updateCarServicing.getParts());

    }

    @Test(dependsOnMethods = {"testUpdate"})
    public void testDelete() throws Exception {
        CarServicing carServicing = (CarServicing)this.carServicingRepo.findOne(this.id);
        this.carServicingRepo.delete(carServicing);
        CarServicing deletedDarServicing = (CarServicing)this.carServicingRepo.findOne(this.id);
        Assert.assertNull(deletedDarServicing);
    }
}
