package com.example.autoservice.dealer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealerService {

    private final DealerRepository dealerRepository;

    @Autowired
    public DealerService(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }

    public List<Dealer> getDealers() {
        return dealerRepository.findAll();
    }

    public void addNewDealer(Dealer dealer) {
        Optional<Dealer> optionalDealer =  dealerRepository.findDealerById(dealer.getId());
        if (optionalDealer.isPresent()) {
            throw new IllegalStateException("Dealer Already Exists");
        }
        dealerRepository.save(dealer);
    }
}
