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
public class Driver implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lisenceCode;
    private int age;



    public Driver(){

    }

    public Driver(Builder builder){
        id = builder.id;
        lisenceCode = builder.lisenceCode;
        age = builder.age;

    }

    public Long getID() {
        return id;
    }

    public String getLisenceCode() {
        return lisenceCode;
    }

    public int getAge() {
        return age;
    }

    public static class Builder{
        private String lisenceCode;
        private int age;
        private Long id;


        public Builder(String lisenceCode){
            this.lisenceCode = lisenceCode;
        }


        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Driver value){
            this.id = value.id;
            this.lisenceCode = value.lisenceCode;
            this.age = value.age;
            return this;
        }

        public Driver build(){
            return new Driver(this);
        }

    }//End
}
