package za.ac.cput.carRentalApp.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.cput.carRentalApp.config.CustomerFactory;
import za.ac.cput.carRentalApp.domain.Customer;

/**
 * Created by student on 2015/08/14.
 */
//@SpringApplicationConfiguration(classes= App.class)
//@WebAppConfiguration
public class CustomerRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    CustomerRepo customerRepo;

    //@Test
    public void testCreate() throws Exception {
        Customer customer = CustomerFactory.createCustomer("Thabo", "Lebese", "10 dorset Street",null,null,null);
        customerRepo.save(customer);
        id = customer.getID();
        Assert.assertNotNull(customer);
    }

   // @Test (dependsOnMethods ="testCreate")
    public void testRead() throws Exception {
        Customer customer = customerRepo.findOne(id);
        Assert.assertNotNull(customer);
    }

    //@Test (dependsOnMethods ="testRead")
    public void testUpdate() throws Exception {
        Customer customer = customerRepo.findOne(id);
        Customer newCustomer = new Customer.Builder(customer.getFirstName()).copy(customer).lastName("Mahlala").build();
        customerRepo.save(newCustomer);
        Customer updatedCustomer = customerRepo.findOne(id);
        Assert.assertEquals("Mahlala",updatedCustomer.getLastName());
    }

    //@Test (dependsOnMethods ="testUpdate")
    public void testDelete() throws Exception {
        Customer customer = customerRepo.findOne(id);
        customerRepo.delete(customer);
        Customer deletedCustomer = customerRepo.findOne(id);
        Assert.assertNull(deletedCustomer);

    }
}
