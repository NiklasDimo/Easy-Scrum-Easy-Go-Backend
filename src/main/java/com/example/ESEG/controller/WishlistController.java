package com.example.ESEG.controller;


import com.example.ESEG.model.Wishlist;
import com.example.ESEG.repository.WishlistRepository;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class WishlistController {

    private final WishlistRepository repository;

    //Constructor
    public WishlistController(WishlistRepository repository)
    {
        this.repository = repository;
    }

    @RequestMapping("/api/wishlist")
    public Iterable<Wishlist> findAll()
    {
        return repository.findAll();
    }

    @RequestMapping("api/wishlist/{username}/{productId}")
    public Wishlist getWishlist(@PathVariable String username, @PathVariable Long productId) {
        return  repository.findByUsernameAndProductId(String.valueOf(username), Long.valueOf(productId));
    }

    //möglichkeit die Wunschliste einer einzelnen Person zu holen aber noch errors
    /*
    @RequestMapping("api/wishlist/{username}")
    public Wishlist getAllWishlistFromSingleUser(@PathVariable String username) {

        return  repository.findByUsername(String.valueOf(username));
    }*/

    @PostMapping(value="/api/wishlist", consumes="application/json", produces="application/json")
    public Wishlist createWishlist(@RequestBody Wishlist wishlist) {
        repository.save(wishlist);
        return wishlist;
    }

    @DeleteMapping("/api/wishlist/{id}")
    public void deleteWishlistItem(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
