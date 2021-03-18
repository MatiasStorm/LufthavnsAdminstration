package com.cph.adminstration.service;

import com.cph.adminstration.model.Gate;
import com.cph.adminstration.repository.dao.GateDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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

    @Test
    void getByID(){

        gate = new Gate();
        gate.setNumber(1);
        gate.setTerminalId(2);
        gate.setGateSize('M');

        Mockito.when(mockedGateDAO.getByID(1)).thenReturn(gate);
        char size = gateService.getByID(1).getGateSize();

        assertEquals('M', size);

        Mockito.verify(mockedGateDAO, times(1)).getByID(1);
    }
}