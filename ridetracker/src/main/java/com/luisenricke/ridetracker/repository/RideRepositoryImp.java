package com.luisenricke.ridetracker.repository;

import com.luisenricke.ridetracker.model.Ride;
import com.luisenricke.ridetracker.repository.util.RideRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RideRepositoryImp implements RideRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Ride get(Integer id) {
        Ride object = jdbcTemplate.queryForObject("SELECT * FROM ride WHERE ride_id = ?", new RideRowMapper(), id);
        return object;
    }

    @Override
    public List<Ride> get() {
        List<Ride> list = jdbcTemplate.query("select * from ride", new RideRowMapper());
        return list;
    }

    @Override
    public Ride create(Ride ride) {
        //        KeyHolder keyHolder = new GeneratedKeyHolder();
        //        jdbcTemplate.update(new PreparedStatementCreator() {
        //            @Override
        //            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        //                PreparedStatement ps = con.prepareStatement("INSERT INTO ride (name, duration) values (?, ?)",
        //                                                            new String[]{"ride_id"}
        //                );
        //                ps.setString(1, ride.getName());
        //                ps.setInt(2, ride.getDuration());
        //                return ps;
        //            }
        //        }, keyHolder);
        //        Number id = keyHolder.getKey();
        //        return id != null ? getRide(id.intValue()) : new Ride();

        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.setGeneratedKeyName("ride_id");
        Map<String, Object> data = new HashMap<>();
        data.put("name", ride.getName());
        data.put("duration", ride.getDuration());

        List<String> columns = new ArrayList<>();
        columns.add("name");
        columns.add("duration");

        insert.setTableName("ride");
        insert.setColumnNames(columns);
        Number id = insert.executeAndReturnKey(data);

        return get(id.intValue());
    }

    @Override
    public Ride update(Ride ride) {
        int updatedId = jdbcTemplate.update("UPDATE ride SET name = ?, duration = ? WHERE ride_id = ?",
                                            ride.getName(), ride.getDuration(), ride.getId()
        );
        return updatedId > 0 ? get(updatedId) : new Ride();
    }

    @Override
    public int delete(int id) {
//        int deletedId = jdbcTemplate.update("DELETE FROM ride WHERE ride_id = ?", id);
//        return deletedId > 0 ? id : -1;
        NamedParameterJdbcTemplate named = new NamedParameterJdbcTemplate(jdbcTemplate);
        Map<String, Object> params = new HashMap<>();
        params.put("ride_id", id);
        named.update("DELETE FROM ride WHERE ride_id = :ride_id", params);
        return id;
    }

    @Override
    public void updatesDate(List<Object[]> pairs) {
        jdbcTemplate.batchUpdate("UPDATE ride SET date = ? where ride_id = ?", pairs);
    }
}
