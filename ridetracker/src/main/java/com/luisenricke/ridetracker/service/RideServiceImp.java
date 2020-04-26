package com.luisenricke.ridetracker.service;

import com.luisenricke.ridetracker.model.Ride;
import com.luisenricke.ridetracker.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideServiceImp implements RideService {

    @Autowired
    private RideRepository rideRepository;

    @Override
    public List<Ride> getRides() {
        return rideRepository.getRides();
    }

    @Override
    public Ride createRide(Ride ride) {
        return rideRepository.createRide(ride);
    }
}
