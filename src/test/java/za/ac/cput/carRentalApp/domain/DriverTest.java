package za.ac.cput.carRentalApp.domain;

import org.junit.Assert;
import za.ac.cput.carRentalApp.config.DriverFactory;

/**
 * Created by student on 2015/04/26.
 */
public class DriverTest {
    //@Before
    public void setUp() throws Exception {


    }

    //@Test
    public void createDriverTest() throws Exception {
        Driver driver = DriverFactory.createDriver("Code8",18);

        Assert.assertEquals("Code8", driver.getLisenceCode());
    }

    //@Test
    public void upDateDriverTest() throws Exception {
        Driver driver = DriverFactory.createDriver("Code8",18);

        Driver newDriver = new Driver.Builder(driver.getLisenceCode()).copy(driver).age(25).build();

        Assert.assertEquals(25, newDriver.getAge());

    }
}
