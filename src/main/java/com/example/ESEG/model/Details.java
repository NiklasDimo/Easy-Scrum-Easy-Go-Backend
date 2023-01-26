package com.example.ESEG.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Table(name = "details")
@Entity
@Getter
@Setter
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private String productName;

    private String title;

    private String description;

    public Details(Long productId, String title, String description, String productName) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.productName =productName;
    }

    public Details() {
    }
}
