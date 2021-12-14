package com.example.autoservice.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public void addNewCar(Car car) {
        Optional<Car> optionalCar =  carRepository.findCarById(car.getId());
        if (optionalCar.isPresent()) {
            throw new IllegalStateException("Car Already Exists.");
        }
        carRepository.save(car);
    }
}
