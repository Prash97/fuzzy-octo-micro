package com.psd.user.service.controller;

import com.psd.user.service.entities.User;
import com.psd.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    //create

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userservice.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    int retryCount = 1;

    @GetMapping("/{userId}")
//    @CircuitBreaker(name="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @Retry(name="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        logger.info("Retry count: {}", retryCount);
        retryCount++;
        User user1 = userservice.getUser(userId);
        return ResponseEntity.ok(user1);
    }

    //fallback method for circuitBreaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("dummy")
                .about("this user is created dummy mail id because service is down ")
                .userId("12341234")
                .build();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = userservice.getAllUser();
        return ResponseEntity.ok(userList);

    }
}
