package com.example.autoservice.dealer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/dealer")
public class DealerController {

    private final DealerService dealerService;

    @Autowired
    public DealerController (DealerService dealerService) {
        this.dealerService = dealerService;
    }

    @GetMapping
    public List<Dealer> getDealers() {
        return dealerService.getDealers();
    }

    @PostMapping
    public void registerDealers(@RequestBody Dealer dealer) {
        dealerService.addNewDealer(dealer);
    }
}
