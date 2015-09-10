package za.ac.cput.carRentalApp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.carRentalApp.config.CompanyFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public class CompanyTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void createCompanyTest() throws Exception {
        List<Employee> employees = new ArrayList<Employee>();

        Company company = CompanyFactory.createCompany("mavis","10 Dorset street", employees);

        Assert.assertEquals("mavis",company.getcompanyName());

    }

    @Test
    public void updateCompanyTest() throws Exception {

        List<Employee> employees = new ArrayList<Employee>();

        Company company = CompanyFactory.createCompany("mavis","10 Dorset street", employees);

        Company newCompany = new Company.Builder(company.getcompanyName()).copy(company).address("11 brie Street").build();

        Assert.assertEquals("11 brie Street",newCompany.getaddress());
    }
}
