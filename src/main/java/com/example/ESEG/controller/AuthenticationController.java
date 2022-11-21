package com.example.ESEG.controller;

import com.example.ESEG.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.security.Principal;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @GetMapping(path = "/basicauth")
    public ResponseEntity<User> login(Principal principle) {

        String name = principle.getName();
        System.out.println(name);
        return new ResponseEntity<User>(
                new User(),
                HttpStatus.OK
        );
    }

}
