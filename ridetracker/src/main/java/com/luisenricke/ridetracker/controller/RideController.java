package com.luisenricke.ridetracker.controller;

import com.luisenricke.ridetracker.model.Ride;
import com.luisenricke.ridetracker.service.RideService;
import com.luisenricke.ridetracker.util.ServiceError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RideController {

    @Autowired
    private RideService rideService;

    @RequestMapping(value = "/ride/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Ride get(@PathVariable Integer id) {
        return rideService.get(id);
    }

    @RequestMapping(value = "/ride", method = RequestMethod.GET)
    @ResponseBody
    public List<Ride> get() {
        return rideService.get();
    }

    @RequestMapping(value = "/ride", method = RequestMethod.POST)
    @ResponseBody
    public Ride create(@RequestBody Ride ride) {
        return rideService.create(ride);
    }

    @RequestMapping(value = "/ride", method = RequestMethod.PUT)
    @ResponseBody
    public Ride update(@RequestBody Ride ride) {
        return rideService.update(ride);
    }

    @RequestMapping(value = "/ride/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable int id) {
        return "The row " + rideService.delete(id) + " was deleted";
    }

    @RequestMapping(value = "/ride/batch", method = RequestMethod.GET)
    @ResponseBody
    public Object batchDate() {
        rideService.batchDate();
        return null;
    }

    @RequestMapping(value = "/ride/exception", method = RequestMethod.GET)
    @ResponseBody
    public Object test() {
        throw new DataAccessException("Testing exception thrown") {
        };
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ServiceError> handle(RuntimeException exception) {
        ServiceError error = new ServiceError(HttpStatus.OK.value(), exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

}
