package za.ac.cput.carRentalApp.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
@Entity
public class Company implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String companyName;
    private String address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    private List<Employee> employees;

    public Company(){
    }

    public Company(Builder builder){

        id = builder.id;
        companyName = builder.companyName;
        address = builder.address;

    }

    public String getcompanyName() {
        return companyName;
    }

    public String getaddress() {
        return address;
    }

    public List<Employee> getEmployee() {
        return employees;
    }

    public Long getID() {
        return id;
    }

    public static class Builder{

        private Long id;
        private String companyName;
        private String address;
        private List<Employee> employees;

        public Builder(String companyName){
            this.companyName = companyName;
        }


        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder employee(List<Employee> employees)
        {
            this.employees = employees;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Company value){
            this.companyName = value.companyName;
            this.address = value.address;
            this.id = value.id;
            this.employees = value.employees;
            return this;
        }

        public Company build(){
            return new Company(this);
        }

    }//End
}
