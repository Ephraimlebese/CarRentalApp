package za.ac.cput.carRentalApp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Customer;
import za.ac.cput.carRentalApp.module.CustomerResource;
import za.ac.cput.carRentalApp.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/26.
 */
@RestController
@RequestMapping(value="/customer/**")
public class CustomerPage {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Booking> getBookings(@PathVariable Long id){
        return customerService.getBookings(id);
    }

    @RequestMapping(value="/customers", method=RequestMethod.GET)
    public List<CustomerResource> getCustomers()
    {
        List<CustomerResource> hateoas = new ArrayList<>();
        List<Customer> customers = customerService.getCustomers();
        for (Customer c: customers)
        {
            CustomerResource res = new CustomerResource.Builder(c.getFirstName())
                    .lastName(c.getLastName())
                    .address(c.getAddress())
                    .booking(c.getBooking())
                    .driver(c.getDrivers())
                    .invoice(c.getInvoices())
                    .id(c.getID())
                    .build();

            Link bookings = new Link("http://localhost:8080/customer" + res.getID().toString())
                    .withRel("cst");

            res.add(bookings);
            hateoas.add(res);
        }

        return hateoas;

    }

}
