package za.ac.cput.carRentalApp.services;

import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Employee;

import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
public interface EmployeeService extends Services<Employee,Long> {
    List<Employee> getEmployee();
    List<Booking> getBookings(Long id);
}
