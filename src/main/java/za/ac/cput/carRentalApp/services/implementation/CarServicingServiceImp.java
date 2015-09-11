package za.ac.cput.carRentalApp.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.carRentalApp.domain.Booking;
import za.ac.cput.carRentalApp.domain.CarServicing;
import za.ac.cput.carRentalApp.domain.Customer;
import za.ac.cput.carRentalApp.repository.CarServicesRepo;
import za.ac.cput.carRentalApp.services.CarServicingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/07/30.
 */
@Service
public class CarServicingServiceImp implements CarServicingService{

    @Autowired
    CarServicesRepo carServicingRepo;


    @Override
    public List<CarServicing> getCarServices(){

        List<CarServicing> allCarServeces = new ArrayList<>();

        Iterable<CarServicing> carServices = carServicingRepo.findAll();

        for (CarServicing carServicing : carServices){
            allCarServeces.add(carServicing);
        }

        return allCarServeces;
    }

    @Override
    public List<Booking> getBookings(Long id){
        return carServicingRepo.findOne(id).getBookings();
    }

    @Override
    public List<Customer> getCustomer(Long id) {
        return null;
    }

    @Override
    public CarServicing findById(Long aLong) {
        return null;
    }

    @Override
    public CarServicing save(CarServicing entity) {
        return null;
    }

    @Override
    public CarServicing update(CarServicing entity) {
        return null;
    }

    @Override
    public void delete(CarServicing entity) {

    }

    @Override
    public List<CarServicing> findAll() {
        return null;
    }
}
