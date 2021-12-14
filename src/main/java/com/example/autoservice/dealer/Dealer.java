package com.example.autoservice.dealer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Dealer {
    @Id
    @SequenceGenerator(
            name = "dealerSequence",
            sequenceName = "dealer.Sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "dealerSequence"
    )
    private Long id;
    private String name;
    private String emailId;
    private String dealerOfCompany;
    private String phoneNo;
    private String country;

    public Dealer() {
    }

    public Dealer(Long id, String name, String emailId, String dealerOfCompany, String phoneNo, String country) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.dealerOfCompany = dealerOfCompany;
        this.phoneNo = phoneNo;
        this.country = country;
    }

    public Dealer(String name, String emailId, String dealerOfCompany, String phoneNo, String country) {
        this.name = name;
        this.emailId = emailId;
        this.dealerOfCompany = dealerOfCompany;
        this.phoneNo = phoneNo;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", dealerOfCompany='" + dealerOfCompany + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
