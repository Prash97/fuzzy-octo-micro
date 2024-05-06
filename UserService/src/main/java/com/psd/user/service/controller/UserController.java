package com.psd.user.service.controller;

import com.psd.user.service.entities.User;
import com.psd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userservice;

    //create

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userservice.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user1 = userservice.getUser(userId);
        return ResponseEntity.ok(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = userservice.getAllUser();
        return ResponseEntity.ok(userList);

    }
}
