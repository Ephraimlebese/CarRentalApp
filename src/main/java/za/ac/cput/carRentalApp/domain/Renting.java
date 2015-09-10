package za.ac.cput.carRentalApp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Renting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lecensePlate;
    private String period;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="emp_id")
    private List<Booking> bookings;

    public Renting(){

    }

    public Renting(Builder builder){
        lecensePlate = builder.lecensePlate;
        period = builder.period;
        id = builder.id;
        bookings = builder.bookings;
    }

    public String getLecensePlate() {
        return lecensePlate;
    }

    public String getPeriod() {
        return period;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Long getID() {
        return id;
    }

    public static class Builder{

        private String lecensePlate;
        private String period;
        private Long id;
        private List<Booking> bookings;


        public Builder(String lecensePlate){
            this.lecensePlate = lecensePlate;
        }

        public Builder period(String period){
            this.period = period;
            return this;
        }

        public Builder booking(List<Booking> bookings)
        {
            this.bookings = bookings;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Renting value){
            this.lecensePlate = value.lecensePlate;
            this.period = value.period;
            this.id = value.id;
            this.bookings = value.bookings;
            return this;
        }

        public Renting build(){
            return new Renting(this);
        }

    }//End
}
