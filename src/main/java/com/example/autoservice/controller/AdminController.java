package com.example.autoservice.controller;


import com.example.autoservice.dto.CarDTO;
import com.example.autoservice.model.Car;
import com.example.autoservice.model.Company;
import com.example.autoservice.model.Dealer;
import com.example.autoservice.service.CarService;
import com.example.autoservice.service.CompanyService;
import com.example.autoservice.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller

public class AdminController {

    @Autowired
    DealerService dealerService;

    @Autowired
    CompanyService companyService;

    @Autowired
    CarService carService;

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/carImages";

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

    @PostMapping("/admin/cars/add")
    public String postCarsAdd(@ModelAttribute("carDTO") CarDTO carDTO,
                              @RequestParam("carImage")MultipartFile file,
                              @RequestParam("imgName")String imgName) throws IOException {
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setModel(carDTO.getModel());
        car.setDealer(dealerService.getDealerById(carDTO.getDealerId()).get());
        car.setCompany(companyService.getCompanyById(carDTO.getCompanyId()).get());
        car.setPrice(carDTO.getPrice());
        car.setColor(carDTO.getColor());
        car.setDescription(carDTO.getDescription());
        String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNamePath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNamePath, file.getBytes());
        } else {
            imageUUID = imgName;
        }
        car.setImageName(imageUUID);
        carService.addCar(car);
        return "redirect:/admin/cars";
    }
 }
