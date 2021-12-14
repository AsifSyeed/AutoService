package com.example.autoservice.company;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Company {
    @Id
    @SequenceGenerator(
            name = "companySequence",
            sequenceName = "companySequence"
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "companySequence"
    )
    private Long id;
    private String name;
    private String country;
    private Integer establishedYear;

    public Company() {
    }

    public Company(Long id, String name, String country, Integer establishedYear) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.establishedYear = establishedYear;
    }

    public Company(String name, String country, Integer establishedYear) {
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
