package com.spd.hotel.HotelService.services;

import com.spd.hotel.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel createHotel(Hotel hotel);

    //get all list of hotels
    List<Hotel> getAll();

    //get single
    Hotel get(String id);

}
