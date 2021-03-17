package com.cph.adminstration.service;

import com.cph.adminstration.model.Arrival;
import com.cph.adminstration.repository.dao.ArrivalDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ArrivalServiceTest {
    @Mock
    ArrivalDAO dao;
    ArrivalService service;

    @BeforeEach
    public void setup(){
        this.service = new ArrivalService(dao);
    }

    @Test
    void create() {
        Arrival arrival = new Arrival();
        service.create(arrival);
        Mockito.verify(dao, Mockito.times(1)).create(arrival);
    }

    @Test
    void readAll() {
        service.readAll();
        Mockito.verify(dao, Mockito.times(1)).readAll();
    }
}