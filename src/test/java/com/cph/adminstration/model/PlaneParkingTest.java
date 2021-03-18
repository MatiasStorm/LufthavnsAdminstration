package com.cph.adminstration.model;

import com.cph.adminstration.repository.dao.ArrivalDAO;
import com.cph.adminstration.repository.dao.GateDAO;
import com.cph.adminstration.service.ArrivalService;
import com.cph.adminstration.service.GateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Transactional
@Sql(value = {"classpath:schema.sql", "classpath:test-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class PlaneParkingTest {
    private static HashMap<Integer, Boolean> gateStatus;
    private static HashMap<Integer, Plane> planesAtGate;
    @Autowired
    JdbcTemplate jdbcTemplate;
    GateDAO dao;
    GateService service;
    List<Gate> gates;
    Plane plane;

    @BeforeEach
    public void setup(){
        this.dao = new GateDAO(jdbcTemplate);
        this.service = new GateService(dao);
        this.gates = service.readAll();
        plane = new Plane();
        plane.setIata("100");
        plane.setPlaneSize('M');
        plane.setType("Fokker 100");
    }

    @Test
    void findGate(){
        if (gateStatus == null){
            gateStatus = new HashMap<>();
            for (int i = 1; i < 27; i++) {
                if (i == 13 || i == 14){
                    continue;
                }
                gateStatus.put(i, true);
            }

        }


        gates = service.readAll();
        String vacantGateNumber = "There are no vacant gates that fit this size plane atm (ass to mouth)";
        for (Gate gate: gates) {
            if (gate.getGateSize() == plane.getPlaneSize() && gateStatus.get(gate.getNumber())){
                if (planesAtGate == null){
                    planesAtGate = new HashMap<>();
                }
                planesAtGate.put(gate.getNumber(), plane);
                gateStatus.replace(gate.getNumber(), false);
                vacantGateNumber = "The plane is docked at gate: " + gate.getNumber();
                break;
            }
        }

       Plane plane1 = new Plane();
        plane1.setIata("FY0");
        plane1.setPlaneSize('H');
        plane1.setType("Fooker Ultimate");

        for (Gate gate: gates) {
            if (gate.getGateSize() == plane1.getPlaneSize() && gateStatus.get(gate.getNumber())){
                if (planesAtGate == null){
                    planesAtGate = new HashMap<>();
                }
                planesAtGate.put(gate.getNumber(), plane1);
                gateStatus.replace(gate.getNumber(), false);
                vacantGateNumber = "The plane is docked at gate: " + gate.getNumber();
                break;
            }
        }

    }

    @Test
    void removeDeparture(){

    }



}