package com.cph.adminstration.service;

import com.cph.adminstration.model.Departure;
import com.cph.adminstration.repository.dao.ArrivalDAO;
import com.cph.adminstration.repository.dao.DepartureDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartureServiceTest {
    @Mock
    DepartureDAO dao;
    DepartureService service;

    @BeforeEach
    public void setup(){
        this.service = new DepartureService(dao);
    }

    @Test
    void create() {
        Departure departure = new Departure();
        service.create(departure);
        Mockito.verify(dao, Mockito.times(1)).create(departure);
    }

    @Test
    void readAll() {
        service.readAll();
        Mockito.verify(dao, Mockito.times(1)).readAll();
    }
}