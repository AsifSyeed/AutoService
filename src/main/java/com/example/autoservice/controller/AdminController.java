package com.example.autoservice.controller;


import com.example.autoservice.dto.CarDTO;
import com.example.autoservice.model.Company;
import com.example.autoservice.model.Dealer;
import com.example.autoservice.service.CarService;
import com.example.autoservice.service.CompanyService;
import com.example.autoservice.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller

public class AdminController {
    @Autowired
    DealerService dealerService;
    @Autowired
    CompanyService companyService;
    @Autowired
    CarService carService;
    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/dealers")
    public String getDealers(Model model) {
        model.addAttribute("dealer", dealerService.getAllDealer());
        return "dealers";
    }

    @GetMapping("/admin/dealers/add")
    public String getDealersAdd(Model model) {
        model.addAttribute("dealer", new Dealer());
        return "dealersAdd";
    }
    @PostMapping("/admin/dealers/add")
    public String postDealersAdd(@ModelAttribute("dealer") Dealer dealer) {
        dealerService.addDealer(dealer);
        return "redirect:/admin/dealers";
    }

    @GetMapping("/admin/dealers/delete/{id}")
    public String deleteDealer(@PathVariable int id) {
        dealerService.removeDealerById(id);
        return "redirect:/admin/dealers";
    }
    @GetMapping("/admin/dealers/update/{id}")
    public String updateDealer(@PathVariable int id, Model model) {
        Optional <Dealer> dealer = dealerService.getDealerById(id);
        if (dealer.isPresent()) {
            model.addAttribute("dealer", dealer.get());
            return "dealersAdd";
        }
        else {
            return "404";
        }
    }

    //Company

    @GetMapping("/admin/companies")
    public String getCompanies(Model model) {
        model.addAttribute("company", companyService.getAllCompany());
        return "companies";
    }

    @GetMapping("/admin/companies/add")
    public String getCompaniesAdd(Model model) {
        model.addAttribute("company", new Company());
        return "companiesAdd";
    }
    @PostMapping("/admin/companies/add")
    public String postCompaniesAdd(@ModelAttribute("company") Company company) {
        companyService.addCompany(company);
        return "redirect:/admin/companies";
    }

    @GetMapping("/admin/companies/delete/{id}")
    public String deleteCompany(@PathVariable int id) {
        companyService.removeCompanyById(id);
        return "redirect:/admin/companies";
    }
    @GetMapping("/admin/companies/update/{id}")
    public String updateCompany(@PathVariable int id, Model model) {
        Optional <Company> company = companyService.getCompanyById(id);
        if (company.isPresent()) {
            model.addAttribute("company", company.get());
            return "companiesAdd";
        }
        else {
            return "404";
        }
    }

    //Car

    @GetMapping("/admin/cars")
    public String getCars(Model model) {
        model.addAttribute("car", carService.getAllCar());
        return "cars";
    }

    @GetMapping("/admin/cars/add")
    public String getCarsAdd(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        model.addAttribute("dealer", dealerService.getAllDealer());
        model.addAttribute("company", companyService.getAllCompany());
        return "carsAdd";
    }
 }
