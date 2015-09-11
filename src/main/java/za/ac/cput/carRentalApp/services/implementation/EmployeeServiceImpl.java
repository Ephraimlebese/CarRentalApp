package za.ac.cput.carRentalApp.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Employee;
import za.ac.cput.carRentalApp.repository.EmployeeRepo;
import za.ac.cput.carRentalApp.services.EmployeeService;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by student on 2015/08/25.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getEmployee()
    {
        List<Employee> allEmployees = new ArrayList<Employee>();

        Iterable<Employee> employees = employeeRepo.findAll();

        for (Employee employee : employees)
        {
            allEmployees.add(employee);
        }

        return allEmployees;
    }

    @Override
    public List<Booking> getBookings(Long id){
        return employeeRepo.findOne(id).getBooking();
    }

    @Override
    public Employee findById(Long aLong) {
        return null;
    }

    @Override
    public Employee save(Employee entity) {
        return null;
    }

    @Override
    public Employee update(Employee entity) {
        return null;
    }

    @Override
    public void delete(Employee entity) {

    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}
