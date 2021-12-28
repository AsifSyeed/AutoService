package com.example.autoservice.controller;

import com.example.autoservice.service.CarService;
import com.example.autoservice.service.CompanyService;
import com.example.autoservice.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    DealerService dealerService;

    @Autowired
    CompanyService companyService;

    @Autowired
    CarService carService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("dealer", dealerService.getAllDealer());
        model.addAttribute("company", companyService.getAllCompany());
        model.addAttribute("car", carService.getAllCar());
        return "shop";
    }

    @GetMapping("/shop/dealer/{id}")
    public String shopByDealer(Model model, @PathVariable int id) {
        model.addAttribute("dealer", dealerService.getAllDealer());
        model.addAttribute("company", companyService.getAllCompany());
        model.addAttribute("car", carService.getAllCarByDealerId(id));
        return "shop";
    }

    @GetMapping("/shop/company/{id}")
    public String shopByCompany(Model model, @PathVariable int id) {
        model.addAttribute("dealer", dealerService.getAllDealer());
        model.addAttribute("company", companyService.getAllCompany());
        model.addAttribute("car", carService.getAllCarByCompanyId(id));
        return "shop";
    }

    @GetMapping("/shop/viewcar/{id}")
    public String viewCar(Model model, @PathVariable int id) {
        model.addAttribute("car", carService.getCarById(id).get());
        return "viewCar";
    }
}
