package com.luisenricke.ridetracker.service;

import com.luisenricke.ridetracker.model.Ride;

import java.util.List;

public interface RideService {

    List<Ride> getRides();

    Ride createRide(Ride ride);
}
