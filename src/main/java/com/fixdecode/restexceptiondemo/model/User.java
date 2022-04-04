package com.fixdecode.restexceptiondemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Please, tell us your name")
    private String name;
    @Email(message = "Email address not valid ")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Please, specify your country")
    private String country;

    public User(String name, String email, String password, String country) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
    }
}
