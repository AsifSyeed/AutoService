package com.example.autoservice.model;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @NotEmpty
    @Email(message = "{errors.invalid_email}")
    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}
    )
    private List<Role> roles;

    @ManyToMany(mappedBy = "bookedByUsers")
    private Set<Car> cars = new HashSet<>();


    public User(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    public User() {
    }
}
