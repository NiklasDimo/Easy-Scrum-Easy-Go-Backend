package com.example.ESEG.model;

import javax.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(){

    }

    private String password;

    private String role;

}
