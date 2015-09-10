package za.ac.cput.carRentalApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category;
    private int KM;

    private Car(){

    }

    public Car(Builder builder){
        id = builder.id;
        category = builder.category;
        KM = builder.KM;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public int getKM() {
        return KM;
    }

    public static class Builder{
        private Long id;
        private String category;
        private int KM;

        public Builder(String category){
            this.category = category;
        }
        

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder KM(int KM){
            this.KM = KM;
            return this;
        }

        public Builder copy(Car value){
            this.id = value.id;
            this.category = value.category;
            this.KM = value.KM;
            return this;

        }

        public Car build(){
            return new Car(this);
        }

    }

}
