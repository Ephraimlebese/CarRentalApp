package za.ac.cput.carRentalApp.services;


import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.carRentalApp.App;
import za.ac.cput.carRentalApp.config.BookingFactory;
import za.ac.cput.carRentalApp.config.CarFactory;
import za.ac.cput.carRentalApp.config.EmployeeFactory;
import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Car;
import za.ac.cput.carRentalApp.domain.Employee;
import za.ac.cput.carRentalApp.repository.EmployeeRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class EmployeeServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private EmployeeService employeeService;
    private Long id;
    @Autowired
    private EmployeeRepo employeeRepo;
    private List<Booking> bookings;
    private List<Car> cars;

    @BeforeMethod
    public void setUp() throws Exception {
        bookings = new ArrayList<>();
        cars = new ArrayList<>();
    }

    @Test
    public void testCreate() throws Exception {
        Car car1 = CarFactory.createCar("Sedan", 1000);
        cars.add(car1);
        Booking booking1 = BookingFactory.createBooking("12July2015", cars);
        bookings.add(booking1);
        Employee employee = EmployeeFactory.createEmployee("Man","Persons","10Orange","Clerk",bookings);
        employeeRepo.save(employee);
        id = employee.getID();
        Assert.assertNotNull(id);
    }

    @Test
    public void testGetBookings() throws Exception {
        List<Booking> bookings = employeeService.getBookings(id);
        Assert.assertTrue(bookings.size() > 0);
    }
}
