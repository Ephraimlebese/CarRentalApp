package za.ac.cput.carRentalApp.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Customer;
import za.ac.cput.carRentalApp.repository.CustomerRepo;
import za.ac.cput.carRentalApp.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/25.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public List<Customer> getCustomers()
    {
        List<Customer> allCustomers = new ArrayList<Customer>();

        Iterable<Customer> customers = customerRepo.findAll();

        for (Customer customer : customers)
        {
            allCustomers.add(customer);
        }

        return allCustomers;
    }

    @Override
    public List<Booking> getBookings(Long id){
        return customerRepo.findOne(id).getBooking();
    }


}
