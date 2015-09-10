package za.ac.cput.carRentalApp.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.carRentalApp.App;
import za.ac.cput.carRentalApp.config.CompanyFactory;
import za.ac.cput.carRentalApp.domain.Company;

/**
 * Created by student on 2015/08/05.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CompanyRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    CompanyRepo companyRepo;

    @Test
    public void testCreate() throws Exception {
        Company company = CompanyFactory.createCompany("mavis", "10 Dorset street", null);
        companyRepo.save(company);
        id = company.getID();
        Assert.assertNotNull(company.getID());
    }

    @Test (dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Company company = companyRepo.findOne(id);
        Assert.assertNotNull(company.getID());
    }

    @Test (dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Company company = companyRepo.findOne(id);
        Company newCompany = new Company.Builder(company.getcompanyName()).copy(company).address("11 brie Street").build();
        companyRepo.save(newCompany);
        Company updatedCompany = companyRepo.findOne(id);
        Assert.assertEquals("11 brie Street",updatedCompany.getaddress());

    }

    @Test (dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Company company = companyRepo.findOne(id);
        companyRepo.delete(company);
        Company deletedCompany = companyRepo.findOne(id);
        Assert.assertNull(deletedCompany);
    }
}
