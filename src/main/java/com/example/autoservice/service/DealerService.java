package com.example.autoservice.service;

import com.example.autoservice.model.Dealer;
import com.example.autoservice.repository.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealerService {
    @Autowired
    DealerRepository dealerRepository;
    public List<Dealer> getAllDealer() {
        return dealerRepository.findAll();
    }
    public void addDealer(Dealer dealer) {
        dealerRepository.save(dealer);
    }
    public void removeDealerById(int id) {
        dealerRepository.deleteById(id);
    }
    public Optional<Dealer> getDealerById(int id) {
        return dealerRepository.findById(id);
    }
}
