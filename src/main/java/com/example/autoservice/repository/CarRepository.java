package com.example.autoservice.repository;

import com.example.autoservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByDealer_Id(int id);

    List<Car> findAllByCompany_Id(int id);
}
