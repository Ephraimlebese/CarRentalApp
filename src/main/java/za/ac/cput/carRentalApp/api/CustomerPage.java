package za.ac.cput.carRentalApp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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

    //-------------------Retrieve Single Subject--------------------------------------------------------

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching customer with id " + id);
        Customer customer = customerService.findById(id);
        if (customer == null) {
            System.out.println("Subject with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer , HttpStatus.OK);
    }



    //-------------------Create a Subject--------------------------------------------------------

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Customer " + customer.getFirstName());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        customerService.save(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getID()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Subject --------------------------------------------------------

    @RequestMapping(value = "/customer/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateSubject(@PathVariable("id") long id, @RequestBody Customer customer) {
        System.out.println("Updating Customer " + id);

        Customer currentCustomer = customerService.findById(id);

        if (currentCustomer==null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        Customer updatedCustomer = new Customer
                .Builder(currentCustomer.getLastName())
                .copy(currentCustomer)
                .build();
        currentCustomer.update(updatedCustomer);
        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
    }

    //------------------- Delete a Subject --------------------------------------------------------

    @RequestMapping(value = "/subject/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteSubject(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Customer with id " + id);

        Customer customer = customerService.findById(id);
        if (customer == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        customer.delete(customer);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }

}
