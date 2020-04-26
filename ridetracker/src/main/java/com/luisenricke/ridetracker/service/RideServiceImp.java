package com.luisenricke.ridetracker.service;

import com.luisenricke.ridetracker.model.Ride;
import com.luisenricke.ridetracker.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RideServiceImp implements RideService {

    @Autowired
    private RideRepository rideRepository;

    @Override
    public Ride get(Integer id) {
        return rideRepository.get(id);
    }

    @Override
    public List<Ride> get() {
        return rideRepository.get();
    }

    @Override
    public Ride create(Ride ride) {
        return rideRepository.create(ride);
    }

    @Override
    public Ride update(Ride ride) {
        return rideRepository.update(ride);
    }

    @Override
    public int delete(int id) {
        return rideRepository.delete(id);
    }

    @Override
    @Transactional
    public void batchDate() {
        List<Ride> rides = rideRepository.get();

        List<Object[]> pairs = new ArrayList<>();
        for (Ride ride : rides) {
            Object[] aux = {new Date(), ride.getId()};
            pairs.add(aux);
        }
        try {
            rideRepository.updatesDate(pairs);
            throw new DataAccessException("Testing exception handling") {
            };

        }catch (DataAccessException ex){
            System.out.println(ex);
        }

    }



}
