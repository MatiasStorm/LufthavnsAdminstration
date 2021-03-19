package com.cph.adminstration.repository.mapper;

import com.cph.adminstration.model.TravelProcessType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

public class TravelProcessTypeMapper implements RowMapper<TravelProcessType> {
    @Override
    public TravelProcessType mapRow(ResultSet resultSet, int i) throws SQLException {
        TravelProcessType travelProcessType = new TravelProcessType();
        travelProcessType.setId(resultSet.getInt("trabel_processtype_id"));
        travelProcessType.setName(resultSet.getString("name"));
        Time time = resultSet.getTime("time");
        travelProcessType.setTime(LocalTime.of(time.getHours(), time.getMinutes(), time.getSeconds()));
        return travelProcessType;
    }
}
