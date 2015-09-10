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
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int amountPaid;
    private int amountOwed;



    public Invoice(){

    }

    public Invoice(Builder builder){
        id = builder.id;
        amountPaid = builder.amountPaid;
        amountOwed = builder.amountOwed;

    }

    public Long getID() {
        return id;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public int getAmountOwed() {
        return amountOwed;
    }

    public static class Builder{

        private Long id;
        private int amountPaid;
        private int amountOwed;

        public Builder(int amountPaid){
            this.amountPaid = amountPaid;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder amountOwed(int amountOwed){
            this.amountOwed = amountOwed;
            return this;
        }

        public Builder copy(Invoice value){
            this.id = value.id;
            this.amountPaid = value.amountPaid;
            this.amountOwed = value.amountOwed;
            return this;
        }

        public Invoice build(){
            return new Invoice(this);
        }

    }//End
}
