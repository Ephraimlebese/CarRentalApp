package za.ac.cput.carRentalApp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Employee implements Person, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private  String lastName;
    private String JobDesc;
    private String address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="cust_id")
    private List<Booking> booking;

    public Employee(){

    }

    public Employee(Builder builder){
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        JobDesc = builder.JobDesc;
        address = builder.address;
        booking = builder.booking;
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

    public List<Booking> getBooking() {
        return booking;
    }

    public String getJobDesc() {
        return JobDesc;
    }

    public static class Builder{

        private Long id;
        private String firstName;
        private  String lastName;
        private String JobDesc;
        private String address;
        private List<Booking> booking;

        public Builder(String firstName){
            this.firstName = firstName;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder JobDesc(String JobDesc){
            this.JobDesc = JobDesc;
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

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Employee value){
            this.id = value.getID();
            this.firstName = value.getFirstName();
            this.lastName = value.getLastName();
            this.JobDesc = value.getJobDesc();
            this.address = value.getAddress();
            this.booking = value.getBooking();
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }

    }//End
}
