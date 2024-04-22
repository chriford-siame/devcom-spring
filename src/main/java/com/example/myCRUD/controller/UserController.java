package com.example.myCRUD.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myCRUD.model.User;
import com.example.myCRUD.repo.UserRepo;

@RestController
public class UserController {

    @Autowired
    public UserRepo userRepo;

    @GetMapping("")
    public String getMethodName() {
        return "Hello world";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllEmployees() {
        try {
            List<User> users = new ArrayList<>();
            userRepo.findAll().forEach(users::add);
            
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users/add")
    public ResponseEntity<User> addBook(@RequestBody User user) {
        User userObj = userRepo.save(user);
        return new ResponseEntity<>(userObj, HttpStatus.OK);
    }
    
}
