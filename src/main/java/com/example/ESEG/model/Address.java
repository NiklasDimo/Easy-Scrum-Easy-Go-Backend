package com.example.ESEG.model;


import lombok.*;


import javax.persistence.*;

@Table(name="address")
@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String title;

    private String lastName;

    private String firstName;

    private String street;

    private Integer houseNr;

    private Integer plz;

    private String city;

    public Address(Long userId, String title, String lastName, String firstName, String street, Integer houseNr, Integer plz, String city) {
        this.userId = userId;
        this.title = title;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.houseNr = houseNr;
        this.plz = plz;
        this.city = city;
    }

    public Address() {
    }
}
