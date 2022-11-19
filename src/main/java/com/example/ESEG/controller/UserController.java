package com.example.ESEG.controller;


import com.example.ESEG.model.Product;
import com.example.ESEG.model.User;
import com.example.ESEG.repository.ProductRepository;
import com.example.ESEG.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins ="http://localhost:4200")

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    //Get full User List
    @RequestMapping("/api/user")
    public Iterable<User> findAll(){
        return repository.findAll();
    }

    //Get single User
    @RequestMapping("api/user/{id}")
    public User getUser (@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    //post new User
    @PostMapping(value="/api/user", consumes="application/json", produces="application/json")
    public User createUser(@RequestBody User user) {
        repository.save(user);
        return user;

    }

    @PutMapping(path="/api/user/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        User current = repository.findById(id).get();
        current.setUserName(body.get("userName"));
        current.setPassword(body.get("password"));
        current.setRole(body.get("role"));
        repository.save(current);

    }

    @DeleteMapping("/api/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }




}
