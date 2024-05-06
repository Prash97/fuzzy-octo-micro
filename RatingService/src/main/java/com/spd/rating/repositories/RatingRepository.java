package com.spd.rating.repositories;

import com.spd.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    //custom methods
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
