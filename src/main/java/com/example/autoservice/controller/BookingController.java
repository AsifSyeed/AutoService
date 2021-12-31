package com.example.autoservice.controller;


import com.example.autoservice.global.GlobalData;
import com.example.autoservice.model.Car;
import com.example.autoservice.model.User;
import com.example.autoservice.repository.CarRepository;
import com.example.autoservice.repository.UserRepository;
import com.example.autoservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookingController {
    @Autowired
    CarService carService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    CarRepository carRepository;

    @GetMapping("/car/{id}")
    public String carBooking(@PathVariable int id) {
        GlobalData.booking.add(carService.getCarById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/booking")
    public String getBooking(Model model) {
        model.addAttribute("bookingCount", GlobalData.booking.size());
        model.addAttribute("total", GlobalData.booking.stream().mapToDouble(Car::getPrice).sum());
        model.addAttribute("totalWithTax", GlobalData.booking.stream().mapToDouble(Car::getPrice).sum() + GlobalData.booking.stream().mapToDouble(Car::getPrice).sum() * 0.1);
        model.addAttribute("booking", GlobalData.booking);

        return "booking";
    }

    private final String getCurrentAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return "hello";
    }

    @GetMapping("/bookedCar/{id}{uid}")
    public String bookCarByUser(
            @PathVariable Long id,
            @PathVariable int uid
    ) {
        User user = userRepository.getById(uid);
        Car car = carService.getCarById(id).get();
        car.setUser(user);
        carRepository.save(car);
        return "redirect:/shop";
    }

    @GetMapping("/booking/removeItem/{index}")
    public String bookingItemRemove(@PathVariable int index) {
        GlobalData.booking.remove(index);
        return "redirect:/booking";
    }
}