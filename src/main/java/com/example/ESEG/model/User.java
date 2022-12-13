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
    private String vorname;
    private String nachname;

    public User(String username, String password, String role, String discount, String vorname, String nachname) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.discount = discount;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public User(){

    }

}
