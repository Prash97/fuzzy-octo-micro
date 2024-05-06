package com.psd.user.service.services;

import com.psd.user.service.entities.User;

import java.util.List;

public interface UserService {

    //UserOperations

    //Create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given UserId
    User getUser(String userId);

    //TODO: delete
    //TODO: update



}
