package com.cph.adminstration.repository.mapper;
import com.cph.adminstration.model.Departure;
import org.springframework.jdbc.core.RowMapper;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;

public class DepartureMapper implements RowMapper<Departure> {

    @Override
    public Departure mapRow(ResultSet resultSet, int i) throws SQLException {
        Departure departure = new Departure();

        departure.setId(resultSet.getInt("departure_id"));
        Date date = resultSet.getDate("departure_date");
        Time time = resultSet.getTime("departure_time");
        departure.setDateTime(LocalDateTime.of(date.getYear(), date.getMonth(), date.getDate(), time.getHours(), time.getMinutes(), 0));
        departure.setRouteNumber(resultSet.getString("route_number"));
        departure.setAC(resultSet.getString("departure_ac"));
        departure.setDestination(resultSet.getString("departure_destination"));
        departure.setDeparted(resultSet.getBoolean("is_departed"));

        return departure;
    }
}
