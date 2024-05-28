package com.psd.user.service.external.services;

import com.psd.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {


    //get
    @GetMapping
    Rating getRatings(String ratingId);

    //post
    @PostMapping
    Rating create(Rating rating);

    //update
    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable String ratingId, Rating rating);

    //delete
    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable String ratingId);
}
