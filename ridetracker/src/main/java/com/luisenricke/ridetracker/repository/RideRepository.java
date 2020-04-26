package com.luisenricke.ridetracker.repository;

import com.luisenricke.ridetracker.model.Ride;

import java.util.List;

public interface RideRepository {

    List<Ride> getRides();

    Ride createRide(Ride ride);

}
