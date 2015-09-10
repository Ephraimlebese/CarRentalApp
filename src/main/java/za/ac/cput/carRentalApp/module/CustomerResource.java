package za.ac.cput.carRentalApp.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.Driver;
import za.ac.cput.carRentalApp.domain.Invoice;

import java.util.List;

/**
 * Created by student on 2015/08/26.
 */
public class CustomerResource extends ResourceSupport {

    private Long resid;
    private String firstName;
    private  String lastName;
    private int phoneNumber;
    private String address;
    private List<Booking> booking;
    private List<Driver> drivers;
    private List<Invoice> invoices;

    public CustomerResource() {
    }


    public Long getID() {
        return resid;
    }


    public String getAddress() {
        return address;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public CustomerResource(Builder builder){
        resid = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        phoneNumber = builder.phoneNumber;
        address = builder.address;
        booking = builder.booking;
        drivers = builder.drivers;
        invoices = builder.invoices;
    }

    public static class Builder{

        private Long id;
        private String firstName;
        private  String lastName;
        private int phoneNumber;
        private String address;
        private List<Booking> booking;
        private List<Driver> drivers;
        private List<Invoice> invoices;

        public Builder(String firstName){
            this.firstName = firstName;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder phoneNumber(int phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder booking(List<Booking> booking)
        {
            this.booking = booking;
            return this;
        }

        public Builder driver(List<Driver> drivers)
        {
            this.drivers = drivers;
            return this;
        }

        public Builder invoice(List<Invoice> invoices)
        {
            this.invoices = invoices;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(CustomerResource value){
            this.id = value.resid;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.phoneNumber = value.phoneNumber;
            this.address = value.address;
            this.booking = value.booking;
            this.invoices = value.invoices;
            return this;
        }

        public CustomerResource build(){
            return new CustomerResource(this);
        }

    }

}
