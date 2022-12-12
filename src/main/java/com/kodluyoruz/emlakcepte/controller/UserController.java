package com.kodluyoruz.emlakcepte.controller;

import com.kodluyoruz.emlakcepte.model.User;
import com.kodluyoruz.emlakcepte.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService service;

    @GetMapping
    public List<User> getAll(){
        System.out.println("getAll - userService :: " + service);
        return service.getAllUser();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        service.createUser(user);
        System.out.println("create - userService :: " + service);
        return  new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{email}")
    public User getByEmail(@PathVariable String email){
        System.out.println("gelen email request'i : " + email);
        System.out.println("getByEmail - userService :: " + service);
        return service.getByEmail(email);
    }
}
