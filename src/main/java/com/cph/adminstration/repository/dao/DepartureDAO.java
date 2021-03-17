package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.Departure;
import com.cph.adminstration.repository.mapper.DepartureMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Repository
public class DepartureDAO implements CRUD_DAO<Departure, Integer> {

    private final DepartureMapper departureMapper = new DepartureMapper();

    private final JdbcTemplate template;

    public DepartureDAO(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Departure create(Departure departure) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO departure " +
                "(departure_date, route_number, departure_time, departure_ac, departure_destination, is_departed)" +
                " VALUES (?, ?, ?, ?, ?, ?)";

        String date = departure.getDateTime().format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        String time = departure.getDateTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));


        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, date);
            ps.setString(2, departure.getRouteNumber());
            ps.setString(3, time);
            ps.setString(4, departure.getAc());
            ps.setString(5, departure.getDestination());
            ps.setBoolean(6, departure.getIsDeparted());
            return ps;
        }, keyHolder);

        departure.setId(keyHolder.getKey().intValue());

        return departure;
    }

    @Override
    public List<Departure> readAll() {
        String sql = "SELECT * FROM departure";
        return template.query(sql, departureMapper);
    }

    @Override
    public Departure getByID(Integer id) {
        return null;
    }

    @Override
    public void update(Departure departure) {

    }

    @Override
    public void delete(Integer id) {

    }
}
