package com.cph.adminstration.repository.mapper;
import com.cph.adminstration.model.Departure;
import org.springframework.jdbc.core.RowMapper;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DepartureMapper implements RowMapper<Departure> {

    @Override
    public Departure mapRow(ResultSet resultSet, int i) throws SQLException {
        Departure departure = new Departure();

        departure.setId(resultSet.getInt("departure_id"));
        Date date = resultSet.getDate("departure_date");
        Time time = resultSet.getTime("departure_time");
        LocalDate datePart = LocalDate.parse(date.toString());
        LocalTime timePart = LocalTime.parse(time.toString());
        LocalDateTime dt = LocalDateTime.of(datePart, timePart);
        departure.setDateTime(dt);
        departure.setRouteNumber(resultSet.getString("route_number"));
        departure.setAc(resultSet.getString("departure_ac"));
        departure.setDestination(resultSet.getString("departure_destination"));
        departure.setIsDeparted(resultSet.getBoolean("is_departed"));

        return departure;
    }
}
