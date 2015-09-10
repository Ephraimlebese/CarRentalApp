package za.ac.cput.carRentalApp.config;

import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Employee;

import java.util.List;

/**
 * Created by student on 2015/04/27.
 */
public class EmployeeFactory {
    public static Employee createEmployee(String firstName, String lastName, String address,String jobDisc, List<Booking> bookings ){
        Employee employee = new Employee
                .Builder(firstName)
                .lastName(lastName)
                .address(address)
                .JobDesc(jobDisc)
                .booking(bookings)
                .build();
        return employee;
    }
}
