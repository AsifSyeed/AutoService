package com.example.autoservice.service;

import com.example.autoservice.model.Car;
import com.example.autoservice.model.User;
import com.example.autoservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }
    public void addCar(Car car) {
        carRepository.save(car);
    }

    public void removeCarById(long id) {
        carRepository.deleteById(id);
    }

    public Optional<Car> getCarById(long id) {
        return carRepository.findById(id);
    }

    public List<Car> getAllCarByDealerId(int id) {
        return carRepository.findAllByDealer_Id(id);
    }

    public List<Car> getAllCarByCompanyId(int id) {
        return carRepository.findAllByCompany_Id(id);
    }

}
