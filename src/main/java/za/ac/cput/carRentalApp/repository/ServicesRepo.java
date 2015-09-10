package za.ac.cput.carRentalApp.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.carRentalApp.domain.CarServicing;

/**
 * Created by student on 2015/05/07.
 */
public interface ServicesRepo extends CrudRepository<CarServicing,Long> {
}
