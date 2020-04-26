package com.luisenricke.ridetracker.service;

import com.luisenricke.ridetracker.model.Ride;

import java.util.List;

public interface RideService {

    Ride get(Integer id);

    List<Ride> get();

    Ride create(Ride ride);

    Ride update(Ride ride);

    int delete(int id);

    void batchDate();
}
