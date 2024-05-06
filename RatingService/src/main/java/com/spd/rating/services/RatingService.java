package com.spd.rating.services;

import com.spd.rating.entities.Rating;
import com.spd.rating.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);

    //get all
    List<Rating> getRatings();

    //get all rating by userID
    List<Rating> getRatingByUserId(String userId);

    //get all by Hotel
    List<Rating> getRatingByHotelId(String userId);


}
