package com.example.ESEG.model;

import javax.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String role;
    private String discount;


    public User(String username, String password, String role, String discount) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.discount = discount;
    }

    public User(){

    }

}
