package com.example.autoservice.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id", referencedColumnName = "dealer_id")
    private Dealer dealer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;
    private String color;
    private double price;
    @Column(length = 2048)
    private String description;
    @Column(length = 2048)
    private String imageName;
}
