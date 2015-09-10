package za.ac.cput.carRentalApp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.carRentalApp.config.EmployeeFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public class EmployeeTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void createEmployeeTest() throws Exception {
        List<Booking> bookings = new ArrayList<Booking>();
        Employee employee = EmployeeFactory.createEmployee("Shanon","Ingozi","15 hope street","Admin clerk",bookings);

        Assert.assertEquals("Ingozi",employee.getLastName());

    }

    @Test
    public void updateEmployeeTest() throws Exception {
        List<Booking> bookings = new ArrayList<Booking>();
        Employee employee = EmployeeFactory.createEmployee("Shanon","Ingozi","15 hope street","Admin clerk",bookings);
        Employee newEmployee = new Employee.Builder(employee.getFirstName()).copy(employee).lastName("Scholz").build();
        Assert.assertEquals("Scholz",newEmployee.getLastName());

    }
}
