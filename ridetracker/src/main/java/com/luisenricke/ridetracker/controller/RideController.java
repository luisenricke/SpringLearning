package com.luisenricke.ridetracker.controller;

import com.luisenricke.ridetracker.model.Ride;
import com.luisenricke.ridetracker.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RideController {

    @Autowired
    private RideService rideService;

    @RequestMapping(value = "/ride", method = RequestMethod.GET)
    public @ResponseBody List<Ride> getRides() {
        return rideService.getRides();
    }

    @RequestMapping(value = "/ride", method = RequestMethod.POST)
    public @ResponseBody Ride createRide(@RequestBody Ride ride) {
        return rideService.createRide(ride);
    }
}
