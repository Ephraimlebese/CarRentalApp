package za.ac.cput.carRentalApp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.carRentalApp.domain.Customer;
import za.ac.cput.carRentalApp.services.CustomerService;

import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String index()
    {
        return "This is Home Page.";
    }

    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public Customer getCustomer(){
        Customer customer = new Customer.Builder("Stunna")
                .lastName("Mahlala")
                .address("11 Kerk")
                .booking(null)
                .driver(null)
                .build();
        return customer;
    }

    @RequestMapping(value = "customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){ return customerService.getCustomers(); }
}
