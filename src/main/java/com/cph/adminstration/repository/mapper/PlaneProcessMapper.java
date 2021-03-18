package com.cph.adminstration.repository.mapper;
import com.cph.adminstration.model.PlaneProcess;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class PlaneProcessMapper implements RowMapper<PlaneProcess> {

    @Override
    public PlaneProcess mapRow(ResultSet resultSet, int i) throws SQLException {

        PlaneProcess planeProcess = new PlaneProcess();

        planeProcess.setWorkId(resultSet.getInt("work_id"));
        planeProcess.setDepartureId(resultSet.getInt("departure_id"));
        planeProcess.setArrivalId(resultSet.getInt("arrival_id"));
        Timestamp start= resultSet.getTimestamp("start");
        Timestamp end = resultSet.getTimestamp("end");
        planeProcess.setStart(LocalDateTime.of(start.getYear(), start.getMonth(), start.getDate(), start.getHours(), start.getMinutes(), start.getSeconds()));
        planeProcess.setEnd(LocalDateTime.of(end.getYear(),end.getMonth(),end.getDate(), end.getHours(), end.getMinutes(), start.getSeconds()));
        planeProcess.setPlaneProcessingId(resultSet.getInt("plane_processing_id"));
        return planeProcess;

    }
}
