package com.cph.adminstration.repository.mapper;
import com.cph.adminstration.model.Arrival;
import org.springframework.jdbc.core.RowMapper;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ArrivalMapper implements RowMapper<Arrival> {


    @Override
    public Arrival mapRow(ResultSet resultSet, int i) throws SQLException {
        Arrival arrival = new Arrival();

        arrival.setId(resultSet.getInt("arrival_id"));
        Date date = resultSet.getDate("arrival_date");
        Time time = resultSet.getTime("arrival_time");
        LocalDate datePart = LocalDate.parse(date.toString());
        LocalTime timePart = LocalTime.parse(time.toString());
        LocalDateTime dt = LocalDateTime.of(datePart, timePart);
        arrival.setDateTime(dt);
        arrival.setRouteNumber(resultSet.getString("route_number"));
        arrival.setAc(resultSet.getString("arrival_ac"));
        arrival.setDestination(resultSet.getString("arrival_destination"));
        arrival.setIsArrived(resultSet.getBoolean("is_arrived"));



        return arrival;
    }
}
