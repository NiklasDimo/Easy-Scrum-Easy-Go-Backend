package com.example.ESEG.model;

import lombok.*;


import javax.persistence.*;

@Table(name = "wishlists")
@Entity
@Getter
@Setter
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private Long productId;

    private String productName;

    public Wishlist(String username, Long productId, String productName) {
        this.username = username;
        this.productId = productId;
        this.productName = productName;
    }

    public Wishlist() {
    }

}
