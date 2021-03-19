package com.cph.adminstration.repository.mapper;

import com.cph.adminstration.model.TravelProcessing;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TravelProcessingMapper implements RowMapper<TravelProcessing> {

    @Override
    public TravelProcessing mapRow(ResultSet resultSet, int i) throws SQLException {
        TravelProcessing travelProcessing = new TravelProcessing();
        travelProcessing.setId(resultSet.getInt("travel_processing_id"));
        travelProcessing.setDepartmentId(resultSet.getInt("department_id"));
        travelProcessing.setTravelProcessId(resultSet.getInt("travel_processtype_id"));
        travelProcessing.setFromDepartureId(resultSet.getInt("from_departure"));
        travelProcessing.setFromArrivalId(resultSet.getInt("from_arrival"));
        travelProcessing.setToDepartureId(resultSet.getInt("to_departure"));
        travelProcessing.setToArrivalId(resultSet.getInt("to_arrival"));
        return travelProcessing;
    }
}
