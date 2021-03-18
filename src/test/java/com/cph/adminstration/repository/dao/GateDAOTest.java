package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.Gate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Transactional
@Sql(value = {"classpath:schema.sql", "classpath:test-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class GateDAOTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void create() {
        Gate gate = new Gate();
        gate.setNumber(100);
        gate.setTerminalId(2);
        gate.setGateSize('H');

        GateDAO dao = new GateDAO(jdbcTemplate);
        Gate actualGate = dao.create(gate);
        assertEquals(actualGate.getNumber(), 100);
    }

    @Test
    void readAll() {
        GateDAO dao = new GateDAO(jdbcTemplate);
        List<Gate> gates = dao.readAll();
        assertEquals(gates.size(), 24);
    }

    @Test
    void getByID() {
        GateDAO dao = new GateDAO(jdbcTemplate);
        Gate gate = dao.getByID(1);
        assertEquals(gate.getNumber(),1);
    }
}