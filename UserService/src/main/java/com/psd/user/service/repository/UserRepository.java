package com.psd.user.service.repository;

import com.psd.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    //want to implement any custom methods then we can do that
}
