package za.ac.cput.carRentalApp.config;

import za.ac.cput.carRentalApp.domain.Car;

/**
 * Created by student on 2015/04/27.
 */
public class CarFactory {
    public static Car createCar(String model, int KM){
        Car car = new Car
                .Builder(model)
                .KM(KM)
                .build();
        return car;
    }
}
