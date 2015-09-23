package za.ac.cput.carRentalApp.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.cput.carRentalApp.config.EmployeeFactory;
import za.ac.cput.carRentalApp.domain.Employee;

/**
 * Created by student on 2015/08/05.
 */
//@SpringApplicationConfiguration(classes= App.class)
//@WebAppConfiguration
public class EmployeeRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    EmployeeRepo employeeRepo;

    //@Test
    public void testCreate() throws Exception {
        Employee employee = EmployeeFactory.createEmployee("Shanon", "Ingozi", "15 hope street", "Admin clerk", null);
        employeeRepo.save(employee);
        id = employee.getID();
        Assert.assertNotNull(employee);
    }

    //@Test (dependsOnMethods ="testCreate")
    public void testRead() throws Exception {
        Employee employee = employeeRepo.findOne(id);
        Assert.assertNotNull(employee);

    }

    //@Test (dependsOnMethods ="testRead")
    public void testUpdate() throws Exception {
        Employee employee = employeeRepo.findOne(id);
        Employee newEmployee = new Employee.Builder(employee.getFirstName()).copy(employee).lastName("Scholz").build();
        employeeRepo.save(newEmployee);
        Employee updatedEmployee = employeeRepo.findOne(id);
        Assert.assertEquals("Scholz", updatedEmployee.getLastName());
    }

    //@Test (dependsOnMethods ="testUpdate")
    public void testDelete() throws Exception {
        Employee employee = employeeRepo.findOne(id);
        employeeRepo.delete(employee);
        Employee deletedEmployee = employeeRepo.findOne(id);
        Assert.assertNull(deletedEmployee);
    }
}
