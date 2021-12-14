package com.example.autoservice.customer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customerSequence",
            sequenceName = "customerSequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customerSequence"
    )
    private Long id;
    private String userName;
    private String fullName;
    private String emailId;
    private String phoneNo;
    private String country;
    private String password;

    public Customer() {
    }

    public Customer(Long id, String userName, String fullName, String emailId, String phoneNo, String country, String password) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.country = country;
        this.password = password;
    }

    public Customer(String userName, String fullName, String emailId, String phoneNo, String country, String password) {
        this.userName = userName;
        this.fullName = fullName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.country = country;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + country + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
