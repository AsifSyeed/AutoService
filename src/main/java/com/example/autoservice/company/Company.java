package com.example.autoservice.company;

import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter

public class Company {
    private Long id;
    private String name;
    private String country;
    private Year establishedYear;

    public Company() {
    }

    public Company(Long id, String name, String country, Year establishedYear) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.establishedYear = establishedYear;
    }

    public Company(String name, String country, Year establishedYear) {
        this.name = name;
        this.country = country;
        this.establishedYear = establishedYear;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", establishedYear=" + establishedYear +
                '}';
    }
}
