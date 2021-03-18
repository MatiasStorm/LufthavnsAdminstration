package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.Arrival;
import com.cph.adminstration.repository.mapper.ArrivalMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Repository
public class ArrivalDAO implements CRUD_DAO<Arrival, Integer> {

    private final ArrivalMapper arrivalMapper = new ArrivalMapper();

    private final JdbcTemplate template;

    public ArrivalDAO(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Arrival create(Arrival arrival) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO arrival " +
                "(arrival_date, route_number, arrival_time, arrival_ac, arrival_destination, is_arrived)" +
                " VALUES (?, ?, ?, ?, ?, ?)";

        String date = arrival.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = arrival.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));



        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, date);
            ps.setString(2, arrival.getRouteNumber());
            ps.setString(3, time);
            ps.setString(4, arrival.getAc());
            ps.setString(5, arrival.getDestination());
            ps.setBoolean(6, arrival.getIsArrived());
            return ps;
        }, keyHolder);

        arrival.setId(keyHolder.getKey().intValue());


        return arrival;
    }

    @Override
    public List<Arrival> readAll() {
        String sql = "SELECT * FROM arrival";
        return template.query(sql, arrivalMapper);
    }

    @Override
    public Arrival getByID(Integer id) {
        return null;
    }

    @Override
    public void update(Arrival arrival) {

    }

    @Override
    public void delete(Integer id) {

    }
}
