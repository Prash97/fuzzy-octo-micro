package com.spd.hotel.HotelService.services.impl;

import com.spd.hotel.HotelService.Exception.ResourceNotFoundException;
import com.spd.hotel.HotelService.entities.Hotel;
import com.spd.hotel.HotelService.repositories.HotelRepository;
import com.spd.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String UUid = UUID.randomUUID().toString();
        hotel.setId(UUid);

        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found Exception !!"+ id));
    }
}
