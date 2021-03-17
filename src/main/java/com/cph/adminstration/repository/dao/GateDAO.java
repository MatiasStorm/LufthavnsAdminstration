package com.cph.adminstration.repository.dao;


import com.cph.adminstration.model.Gate;
import com.cph.adminstration.repository.mapper.GateMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class GateDAO implements CRUD_DAO<Gate, Integer> {

    private final JdbcTemplate template;
    private final GateMapper gateMapper = new GateMapper();

    public GateDAO(JdbcTemplate template) {this.template = template;}


    @Override
    public Gate create(Gate gate) {


        String sql = "INSERT INTO gate" +
                "(number, terminal_id, gate_size)" + "VALUES (?,?,?)";

        template.update(sql, gate.getNumber(), gate.getTerminal_id(), gate.getGate_size());
        return gate;
    }

    @Override
    public List<Gate> readAll() {
        String sql = "SELECT * FROM gate";
        return template.query(sql, gateMapper);
    }

    @Override
    public Gate getByID(Integer id) {
        return null;
    }

    @Override
    public void update(Gate gate) {

    }

    @Override
    public void delete(Integer id) {

    }
}
