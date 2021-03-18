package com.cph.adminstration.service;

import com.cph.adminstration.model.PlaneProcess;
import com.cph.adminstration.repository.dao.PlaneProcessDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PlaneProcessServiceTest {


    @Mock
    PlaneProcessDAO dao;
    PlaneProcessService service;

    @BeforeEach
    public void setup(){
        this.service = new PlaneProcessService(dao);
    }

    @Test
    void create() {
        PlaneProcess planeProcess = new PlaneProcess();
        service.create(planeProcess);
        Mockito.verify(dao, Mockito.times(1)).create(planeProcess);
    }
    @Test
    void readAll() {
        service.readAll();
        Mockito.verify(dao, Mockito.times(1)).readAll();
    }

}