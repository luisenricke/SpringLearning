package com.luisenricke.ridetracker.repository;

import com.luisenricke.ridetracker.model.Ride;
import com.luisenricke.ridetracker.repository.util.RideRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RideRepositoryImp implements RideRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Ride getRide(Integer id) {
        Ride object = jdbcTemplate.queryForObject("SELECT * FROM ride WHERE ride_id = ?", new RideRowMapper(), id);
        return object;
    }

    @Override
    public List<Ride> getRides() {
        List<Ride> list = jdbcTemplate.query("select * from ride", new RideRowMapper());
        return list;
    }

    @Override
    public Ride createRide(Ride ride) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement("INSERT INTO ride (name, duration) values (?, ?)",
                                                            new String[]{"ride_id"}
                );
                ps.setString(1, ride.getName());
                ps.setInt(2, ride.getDuration());
                return ps;
            }
        }, keyHolder);
        Number id = keyHolder.getKey();
        return id != null ? getRide(id.intValue()) : new Ride();
    }


}
