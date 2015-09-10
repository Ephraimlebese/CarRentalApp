package za.ac.cput.carRentalApp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Customer implements Person, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private  String lastName;
    private int phoneNumber;
    private String address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="cust_id")
    private List<Booking> booking;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="cust_id")
    private List<Driver> drivers;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="cust_id")
    private List<Invoice> invoices;


    private Customer(){

    }
    public Customer(Builder builder){
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        phoneNumber = builder.phoneNumber;
        address = builder.address;
        booking = builder.booking;
        drivers = builder.drivers;
        invoices = builder.invoices;
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
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

        public Builder copy(Customer value){
            this.id = value.id;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.phoneNumber = value.phoneNumber;
            this.address = value.address;
            this.booking = value.booking;
            this.invoices = value.invoices;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }

    }

}
