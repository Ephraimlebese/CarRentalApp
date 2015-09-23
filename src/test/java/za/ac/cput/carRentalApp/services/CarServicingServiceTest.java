package za.ac.cput.carRentalApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import za.ac.cput.carRentalApp.config.BookingFactory;
import za.ac.cput.carRentalApp.config.CarFactory;
import za.ac.cput.carRentalApp.config.CarServicesFactory;
import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Car;
import za.ac.cput.carRentalApp.domain.CarServicing;
import za.ac.cput.carRentalApp.repository.CarServicesRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/19.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class CarServicingServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CarServicingService carServicingService;
    private Long id;
    @Autowired
    private CarServicesRepo carServicesRepo;
    private List<Booking> bookings;
    private List<Car> cars;

    //@BeforeMethod
    public void setUp() throws Exception {
        bookings = new ArrayList<>();
        cars = new ArrayList<>();

    }

    //@Test
    public void testCreate() throws Exception {
        Car car1 = CarFactory.createCar("Sedan",1000);
        cars.add(car1);
        Booking booking1 = BookingFactory.createBooking("12May2015",cars);
        bookings.add(booking1);

        CarServicing carServicingService = CarServicesFactory.createServices(12.01, "Mirror", bookings, cars);
        carServicesRepo.save(carServicingService);
        id = carServicingService.getID();

        Assert.assertNotNull(id);
    }

    //@Test
    public void testGetCarServices() throws Exception {
        List<Booking> bookings= carServicingService.getBookings(id);
        Assert.assertTrue(bookings.size() == 1);
    }
}
