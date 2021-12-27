package com.example.autoservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dealer_id")
    private int id;

    private String name;
    private String city;
    private String country;
}
