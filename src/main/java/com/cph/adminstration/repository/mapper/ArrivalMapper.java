package com.cph.adminstration.repository.mapper;
import com.cph.adminstration.model.Arrival;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArrivalMapper implements RowMapper<Arrival> {


    @Override
    public Arrival mapRow(ResultSet resultSet, int i) throws SQLException {
        Arrival arrival = new Arrival();

        arrival.setId(resultSet.getInt("arrival_id"));
       // arrival.setDateTime(resultSet.getTimestamp());

        return arrival;
    }
}
