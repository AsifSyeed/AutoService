package com.example.autoservice.service;

import com.example.autoservice.model.Car;
import com.example.autoservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

}
