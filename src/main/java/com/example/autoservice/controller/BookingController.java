package com.example.autoservice.controller;


import com.example.autoservice.global.GlobalData;
import com.example.autoservice.model.Car;
import com.example.autoservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookingController {
    @Autowired
    CarService carService;

    @GetMapping("/carBooking/{id}")
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


}
