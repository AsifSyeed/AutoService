package com.example.autoservice.repository;

import com.example.autoservice.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository <Dealer, Integer> {

}
