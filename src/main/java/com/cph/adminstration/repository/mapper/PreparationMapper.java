package com.cph.adminstration.repository.mapper;
import com.cph.adminstration.model.Preparation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;

public class PreparationMapper implements RowMapper<Preparation> {

    @Override
    public Preparation mapRow(ResultSet resultSet, int i) throws SQLException {

        Preparation preparation = new Preparation();

        preparation.setId(resultSet.getInt("work_id"));
        preparation.setDepartureID(resultSet.getInt("departure_id"));
        preparation.setArrival_id(resultSet.getInt("arrival_id"));
        Time start= resultSet.getTime("start");
        Time end = resultSet.getTime("end");
        preparation.setStart(LocalDateTime.of(start.getYear(), start.getMonth(), start.getDate(), start.getHours(), start.getMinutes(), 0));;
        preparation.setFinish(LocalDateTime.of(end.getYear(),end.getMonth(),end.getDate(), end.getHours(), end.getMinutes(),0));
        preparation.setPlaneProcessingId(resultSet.getInt("plane_processing_id"));
        return preparation;

    }
}
