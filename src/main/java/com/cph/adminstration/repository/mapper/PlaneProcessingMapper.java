package com.cph.adminstration.repository.mapper;
import com.cph.adminstration.model.PlaneProcessing;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class PlaneProcessingMapper implements RowMapper<PlaneProcessing> {

    @Override
    public PlaneProcessing mapRow(ResultSet resultSet, int i) throws SQLException {

        PlaneProcessing planeProcessing = new PlaneProcessing();

        planeProcessing.setWorkId(resultSet.getInt("work_id"));
        planeProcessing.setDepartureId(resultSet.getInt("departure_id"));
        planeProcessing.setArrivalId(resultSet.getInt("arrival_id"));
        Timestamp start= resultSet.getTimestamp("start");
        Timestamp end = resultSet.getTimestamp("end");
        planeProcessing.setStart(LocalDateTime.of(start.getYear(), start.getMonth(), start.getDate(), start.getHours(), start.getMinutes(), start.getSeconds()));
        planeProcessing.setEnd(LocalDateTime.of(end.getYear(),end.getMonth(),end.getDate(), end.getHours(), end.getMinutes(), start.getSeconds()));
        planeProcessing.setPlaneProcessingId(resultSet.getInt("plane_processing_id"));
        return planeProcessing;

    }
}
