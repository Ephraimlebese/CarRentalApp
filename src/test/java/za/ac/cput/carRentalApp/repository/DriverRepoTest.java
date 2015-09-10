package za.ac.cput.carRentalApp.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.carRentalApp.App;
import za.ac.cput.carRentalApp.config.DriverFactory;
import za.ac.cput.carRentalApp.domain.Driver;

/**
 * Created by student on 2015/08/04.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class DriverRepoTest  extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    DriverRepo driverRepo;

    @Test
    public void testCreate() throws Exception {
        Driver driver = DriverFactory.createDriver("Code8",23);
        driverRepo.save(driver);
        id = driver.getID();

        Assert.assertEquals("Code8", driver.getLisenceCode());
    }

    @Test (dependsOnMethods ="testCreate")
    public void testRead() throws Exception {
        Driver driver = driverRepo.findOne(id);
        Assert.assertNotNull(driver);
    }

    @Test (dependsOnMethods ="testRead")
    public void testUpdate() throws Exception {
        Driver driver = driverRepo.findOne(id);
        Driver newDriver = new Driver.Builder(driver.getLisenceCode()).copy(driver).age(25).build();
        driverRepo.save(newDriver);
        Driver updatedDriver = driverRepo.findOne(id);
        Assert.assertEquals(25,updatedDriver.getAge());
    }

    @Test (dependsOnMethods ="testUpdate")
    public void testDelete() throws Exception {
        Driver driver = driverRepo.findOne(id);
        driverRepo.delete(driver);
        Driver deletedDriver = driverRepo.findOne(id);
        Assert.assertNull(deletedDriver);
    }
}
