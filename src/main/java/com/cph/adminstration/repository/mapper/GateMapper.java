package com.cph.adminstration.repository.mapper;

import com.cph.adminstration.model.Gate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GateMapper implements RowMapper<Gate> {

    @Override
    public Gate mapRow(ResultSet resultSet, int i) throws SQLException {
        Gate gate = new Gate();

        gate.setNumber(resultSet.getInt("number"));
        gate.setTerminal_id(resultSet.getInt("terminal_id"));
        gate.setGate_size(resultSet.getString("gate_size").charAt(0));

        return gate;
    }

}
