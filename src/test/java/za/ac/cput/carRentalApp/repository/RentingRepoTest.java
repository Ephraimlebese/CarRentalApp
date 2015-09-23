package za.ac.cput.carRentalApp.repository;


import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.cput.carRentalApp.config.RentingFactory;
import za.ac.cput.carRentalApp.domain.Renting;

//@SpringApplicationConfiguration(classes= App.class)
//@WebAppConfiguration
public class RentingRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    RentingRepo rentingRepo;

    //@Test
    public void testCreate() throws Exception {
        Renting renting = RentingFactory.createRenting("CA120","10days",null);
        rentingRepo.save(renting);
        id = renting.getID();
        Assert.assertNotNull(renting.getID());
    }

    //@Test (dependsOnMethods ="testCreate")
    public void testRead() throws Exception {
        Renting renting = rentingRepo.findOne(id);
        Assert.assertNotNull(renting.getID());
    }

   // @Test (dependsOnMethods ="testRead")
    public void testUpdate() throws Exception {
        Renting renting = rentingRepo.findOne(id);
        Renting newRenting = new Renting.Builder(renting.getLecensePlate()).copy(renting).period("1").build();
        rentingRepo.save(newRenting);
        Renting updatedRenting = rentingRepo.findOne(id);
        Assert.assertEquals("1", updatedRenting.getPeriod());
    }

    //@Test (dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Renting renting = rentingRepo.findOne(id);
        rentingRepo.delete(renting);
        Renting deletedRenting = rentingRepo.findOne(id);
        Assert.assertNull(deletedRenting);
    }
}