package com.luisenricke.ridetracker.repository;

import com.luisenricke.ridetracker.model.Ride;

import java.util.List;

public interface RideRepository {

    Ride get(Integer id);

    List<Ride> get();

    Ride create(Ride ride);

    Ride update(Ride ride);

    int delete(int id);

    void updatesDate(List<Object[]> pairs);
}
