package com.example.ESEG.controller;


import com.example.ESEG.model.User;
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
    public User getUser (@PathVariable Long id) {
        return repository.findById(Long.valueOf(id)).orElse(null);
    }

    //post new User
    @PostMapping(value="/api/user", consumes="application/json", produces="application/json")
    public User createUser(@RequestBody User user) {
        if (repository.findByUsername(user.getUsername()) != null){
            throw new RuntimeException("Username already exist");
        }
        repository.save(user);
        return user;
    }

    @PutMapping(path="/api/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody Map<String, String> body) {
        User current = repository.findById(id).get();
        current.setUsername(body.get("username"));
        current.setPassword(body.get("password"));
        current.setRole(body.get("role"));
        repository.save(current);

    }

    @PatchMapping(path="/api/user/{Id}")
    public void patchUser(@PathVariable long Id, @RequestBody Map<String, Object> changes){
        User user = repository.findById(Id).get();
        mapPersistenceModelToRestModel(user);
        changes.forEach(
                (change,value) ->{
                    switch (change){
                        case "username": user.setUsername((String) value); repository.save(user);
                        break;
                        case "password": user.setPassword((String) value); repository.save(user);
                        break;
                        case "role": user.setRole((String) value); repository.save(user);
                        break;
                    }
                }
        );

    }

    @DeleteMapping("/api/user/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        repository.deleteById(Long.valueOf(id));
    }

    private User mapPersistenceModelToRestModel(User user){
        User userRestModel = new User();
        userRestModel.setId(user.getId());
        userRestModel.setUsername(user.getUsername());
        userRestModel.setRole(user.getRole());
        userRestModel.setPassword(user.getPassword());
        return userRestModel;
    }

}
