package za.ac.cput.carRentalApp.config;

import za.ac.cput.carRentalApp.domain.Company;
import za.ac.cput.carRentalApp.domain.Employee;

import java.util.List;

/**
 * Created by student on 2015/05/05.
 */
public class CompanyFactory {
    public static Company createCompany(String name, String address,List<Employee> employees){
        Company company = new Company
                .Builder(name)
                .address(address)
                .employee(employees)
                .build();
        return company;
    }
}
