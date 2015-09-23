package za.ac.cput.carRentalApp.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.cput.carRentalApp.config.InvoiceFactory;
import za.ac.cput.carRentalApp.domain.Invoice;

/**
 * Created by student on 2015/08/04.
 */
//@SpringApplicationConfiguration(classes= App.class)
//@WebAppConfiguration
public class InvoiceRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    InvoiceRepo invoiceRepo;

    //@Test
    public void testCreate() throws Exception {
        Invoice invoice = InvoiceFactory.createInvoice(150, 150);
        invoiceRepo.save(invoice);
        id =  invoice.getID();
        Assert.assertNotNull(invoice.getID());
    }

    //@Test(dependsOnMethods ="testCreate")
    public void testRead() throws Exception {

        Invoice invoice = invoiceRepo.findOne(id);

        Assert.assertNotNull(invoice.getID());
    }

    //@Test (dependsOnMethods ="testRead")
    public void testUpdate() throws Exception {
        Invoice invoice = invoiceRepo.findOne(id);

        Invoice newInvoice = new Invoice.Builder(invoice.getAmountPaid()).copy(invoice).amountOwed(100).build();
        invoiceRepo.save(newInvoice);
        Invoice updatedInvoice = invoiceRepo.findOne(id);
        Assert.assertEquals(100, updatedInvoice.getAmountOwed());
    }

    //@Test (dependsOnMethods ="testUpdate")
    public void testDelete() throws Exception {
        Invoice invoice = invoiceRepo.findOne(id);
        invoiceRepo.delete(invoice);
        Invoice deletedInvoice = invoiceRepo.findOne(id);
        Assert.assertNull(deletedInvoice);
    }
}
