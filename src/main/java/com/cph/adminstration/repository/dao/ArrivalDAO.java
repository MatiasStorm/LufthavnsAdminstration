package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.Arrival;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@Repository
public class ArrivalDAO implements CRUD_DAO<Arrival, Integer> {

    private final JdbcTemplate template;

    public ArrivalDAO(JdbcTemplate template) {
        this.template = template;
    }


    @Override
    public Arrival create(Arrival arrival) {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            String sql = "INSERT INTO arrival " +
                    "(arrival_date, route_number, arrival_time, arrival_ac, arrival_destination, is_arrived, airplane_id)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?)";


            String date = arrival.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String time = arrival.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            template.update(sql, date, arrival.getRouteNumber(), time, arrival.getAC(), arrival.getDestination(), arrival.getArrived(), arrival.getAirplaneID());
            template.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, date);
                ps.setString(2, arrival.getRouteNumber());
                ps.setString(3, time);
                ps.setString(4, arrival.getAC());
                ps.setString(5, arrival.getDestination());
                ps.setBoolean(6, arrival.getArrived());
                ps.setInt(7, arrival.getAirplaneID());
                return ps;
            }, keyHolder);

            arrival.setId((Integer) keyHolder.getKey());

        return arrival;
    }

    @Override
    public List<Arrival> readAll() {
        return null;
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
