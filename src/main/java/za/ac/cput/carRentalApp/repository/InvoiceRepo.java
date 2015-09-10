package za.ac.cput.carRentalApp.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.carRentalApp.domain.Invoice;

/**
 * Created by student on 2015/05/07.
 */
public interface InvoiceRepo extends CrudRepository<Invoice,Long> {
}
