package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.PlaneProcessing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
@Sql(value = {"classpath:schema.sql", "classpath:test-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@JdbcTest
class PlaneProcessingTypeDAOTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void create (){
        PlaneProcessing plane = new PlaneProcessing();
        plane.setWorkId(1);
        plane.setDepartureId(1);
        plane.setArrivalId(1);
        plane.setStart(LocalDateTime.of(2000,1,1,0,0,0));
        plane.setEnd(LocalDateTime.of(2010,1,1,0,0,0));
        PlaneProcessingDAO dao = new PlaneProcessingDAO(jdbcTemplate);
        PlaneProcessing planeProcessing = dao.create(plane);
        assertEquals(2, planeProcessing.getPlaneProcessingId());
    }



}