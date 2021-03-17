package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.Arrival;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Transactional
@Sql(value = {"classpath:schema.sql", "classpath:test-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ArrivalDAOTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Test
    void create() {
        Arrival arrival = new Arrival();
        arrival.setDateTime(LocalDateTime.of(2021, 1, 1, 10, 0, 0));
        arrival.setRouteNumber("TRC22");
        arrival.setAc("100");
        arrival.setDestination("AAR");
        arrival.setIsArrived(false);
        ArrivalDAO dao = new ArrivalDAO(jdbcTemplate);
        Arrival actualArrival = dao.create(arrival);
        assertEquals(actualArrival.getId(), 5);
    }

    @Test
    void readAll() {
        ArrivalDAO dao = new ArrivalDAO(jdbcTemplate);
        List<Arrival> arrivals = dao.readAll();
        assertEquals(arrivals.size(), 4);
    }
}