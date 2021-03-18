package com.cph.adminstration.repository.dao;

import com.cph.adminstration.model.Arrival;
import com.cph.adminstration.model.Plane;
import com.cph.adminstration.model.PlaneProcess;
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
class PlaneProcessDAOTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void create (){
        PlaneProcess plane = new PlaneProcess();
        plane.setWork_id(1);
        plane.setDepartureId(1);
        plane.setArrivalId(1);
        plane.setStart(LocalDateTime.of(2000,1,1,0,0,0));
        plane.setEnd(LocalDateTime.of(2010,1,1,0,0,0));
        PlaneProcessDAO dao = new PlaneProcessDAO(jdbcTemplate);
        PlaneProcess planeProcess = dao.create(plane);
        assertEquals(2,planeProcess.getPlaneProcessingId());
    }



}