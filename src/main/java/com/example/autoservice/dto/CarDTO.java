package com.example.autoservice.dto;

import lombok.Data;

@Data
public class CarDTO {
    private Long id;
    private String model;

    private int dealerId;
    private int companyId;
    private double price;
    private String color;
    private String description;
    private String imageName;
}
