package za.ac.cput.carRentalApp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class CarServicing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double amount;
    private String parts;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="service_id")
    private List<Booking> bookings;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="service_id")
    private List<Car> cars;

    public CarServicing(){

    }

    public CarServicing(Builder builder){
        id = builder.id;
        amount = builder.amount;
        parts = builder.parts;
        bookings = builder.bookings;
        cars = builder.cars;
    }

    public Double getamount() {
        return amount;
    }

    public String getParts() {
        return parts;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Long getID() {
        return id;
    }

    public static class Builder{

        private Long id;
        private Double amount;
        private String parts;
        private List<Booking> bookings;
        private List<Car> cars;

        public Builder(Double amount){
            this.amount = amount;
        }

        public Builder parts(String parts){
            this.parts = parts;
            return this;
        }

        public Builder booking(List<Booking> bookings)
        {
            this.bookings = bookings;
            return this;
        }

        public Builder cars(List<Car> cars)
        {
            this.cars = cars;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(CarServicing value){
            this.amount = value.getamount();
            this.parts = value.getParts();
            this.id = value.getID();
            this.bookings = value.getBookings();
            this.cars = value.getCars();
            return this;
        }

        public CarServicing build(){
            return new CarServicing(this);
        }

    }//End
}
