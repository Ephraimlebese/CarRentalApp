package za.ac.cput.carRentalApp.domain;

//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Booking  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="service_id")
    private List<Car> cars;

    public Booking(){

    }
    public Booking(Builder builder){
        id = builder.id;
        date = builder.date;

    }

    public String getDate() {
        return date;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Long getID() {
        return id;
    }

    public static class Builder{
        private String date;
        private Long id;
        private List<Car> cars;

        public Builder(String date){
            this.date=date;
        }

        public Builder date(String date)
        {
            this.date = date;
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

        public Builder copy(Booking value){
            this.id = value.id;
            this.date = value.date;
            this.cars = value.cars;
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }
    }
}
