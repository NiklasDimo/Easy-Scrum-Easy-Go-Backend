package com.example.ESEG.repository;

import com.example.ESEG.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Wishlist findByUsername(String username);
    Wishlist findByUsernameAndProductId(String username, Long productId);
}
