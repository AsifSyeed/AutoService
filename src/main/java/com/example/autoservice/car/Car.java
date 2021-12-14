package com.example.autoservice.car;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Car {
    @Id
    @SequenceGenerator(
            name = "carSequence",
            sequenceName = "carSequence"
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "carSequence"
    )
    private Long id;
    private String model;
    private String company;
    private Integer releasedYear;

    public Car() {
    }

    public Car(Long id, String model, String company, Integer releasedYear) {
        this.id = id;
        this.model = model;
        this.company = company;
        this.releasedYear = releasedYear;
    }

    public Car(String model, String company, Integer releasedYear) {
        this.model = model;
        this.company = company;
        this.releasedYear = releasedYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", releasedYear=" + releasedYear +
                '}';
    }
}
