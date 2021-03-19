package com.cph.adminstration.repository.mapper;

import com.cph.adminstration.model.PlaneProcessingType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

public class PlaneProcessingTypeMapper implements RowMapper<PlaneProcessingType> {


    @Override
    public PlaneProcessingType mapRow(ResultSet resultSet, int i) throws SQLException {

        PlaneProcessingType planeProcessingType = new PlaneProcessingType();

        planeProcessingType.setWorkId(resultSet.getInt("work_id"));
        planeProcessingType.setWorkType(resultSet.getString("work_type"));
        planeProcessingType.setDepartmentId(resultSet.getInt("department_id"));
        Time timeSmall = resultSet.getTime("time_small");
        planeProcessingType.setTimeSmall(LocalTime.of(timeSmall.getHours(),timeSmall.getMinutes(), timeSmall.getSeconds()));
        Time timeStandard = resultSet.getTime("time_standard");
        planeProcessingType.setTimeSmall(LocalTime.of(timeStandard.getHours(),timeStandard.getMinutes(), timeStandard.getSeconds()));
        Time timeLarge = resultSet.getTime("time_large");
        planeProcessingType.setTimeSmall(LocalTime.of(timeLarge.getHours(),timeLarge.getMinutes(), timeLarge.getSeconds()));


        return planeProcessingType;
    }
}
