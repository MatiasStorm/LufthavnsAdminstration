package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.Departure;
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
class DepartureDAOTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void create() {
        Departure departure = new Departure();
        departure.setDateTime(LocalDateTime.of(2021, 1, 1, 10, 0, 0));
        departure.setRouteNumber("TRC22");
        departure.setAc("100");
        departure.setDestination("AAR");
        departure.setIsDeparted(false);
        DepartureDAO dao = new DepartureDAO(jdbcTemplate);
        Departure actualDeparture = dao.create(departure);
        assertEquals(actualDeparture.getId(), 5);
    }

    @Test
    void readAll() {
        DepartureDAO dao = new DepartureDAO(jdbcTemplate);
        List<Departure> departures = dao.readAll();
        assertEquals(departures.size(), 4);
    }
}