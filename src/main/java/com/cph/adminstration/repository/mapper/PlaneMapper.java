package com.cph.adminstration.repository.mapper;


import com.cph.adminstration.model.Plane;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaneMapper implements RowMapper<Plane> {

    @Override
    public Plane mapRow(ResultSet resultSet, int i) throws SQLException {

        Plane plane = new Plane();

        plane.setIata(resultSet.getInt("iata"));
        plane.setType(resultSet.getString("type"));
        plane.setPlaneSize(resultSet.getString("size").charAt(0));

        return plane;
    }
}
