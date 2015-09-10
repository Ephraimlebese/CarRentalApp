package za.ac.cput.carRentalApp.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.carRentalApp.config.InvoiceFactory;

/**
 * Created by student on 2015/04/26.
 */
public class InvoiceTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void createInvoice() throws Exception {
        Invoice invoice = InvoiceFactory.createInvoice(150,150);
        Assert.assertEquals(150,invoice.getAmountOwed());
    }

    @Test
    public void updateInvoice() throws Exception {
        Invoice invoice = InvoiceFactory.createInvoice(150,150);
        Invoice newInvoice = new Invoice.Builder(invoice.getAmountPaid()).copy(invoice).amountOwed(155).build();
        Assert.assertEquals(155,newInvoice.getAmountOwed());

    }

    @After
    public void tearDown() throws Exception {


    }
}
