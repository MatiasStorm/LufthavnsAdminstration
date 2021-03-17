package com.cph.adminstration.service;

import com.cph.adminstration.model.Gate;
import com.cph.adminstration.repository.dao.GateDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class GateServiceTest {

    Gate gate;
    List<Gate> gateList = new ArrayList<>();


    GateService gateService;

    @Mock
    GateDAO mockedGateDAO;

    @BeforeEach
    void setUp() {
       gateService = new GateService(mockedGateDAO);

        gate = new Gate();
        gate.setNumber(1);
        gate.setTerminal_id(1);
        gate.setGate_size('M');

    }

    @Test
    void create() {
        gateService.create(gate);

        Mockito.verify(mockedGateDAO, times(1)).create(gate);
    }

    @Test
    void readAll() {
        gateList = gateService.readAll();
        Mockito.verify(mockedGateDAO, times(1)).readAll();
    }
}