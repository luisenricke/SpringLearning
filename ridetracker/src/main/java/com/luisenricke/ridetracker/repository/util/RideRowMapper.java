package com.luisenricke.ridetracker.repository.util;

import com.luisenricke.ridetracker.model.Ride;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RideRowMapper implements RowMapper<Ride> {

    @Override
    public Ride mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ride object = new Ride();
        object.setId(rs.getInt("ride_id"));
        object.setName(rs.getString("name"));
        object.setDuration(rs.getInt("duration"));
        return object;
    }
}
