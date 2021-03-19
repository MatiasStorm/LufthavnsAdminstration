package com.cph.adminstration.service;

import com.cph.adminstration.model.PlaneProcessing;
import com.cph.adminstration.repository.dao.PlaneProcessingDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlaneProcessingServiceTest {


    @Mock
    PlaneProcessingDAO dao;
    PlaneProcessingService service;

    @BeforeEach
    public void setup(){
        this.service = new PlaneProcessingService(dao);
    }

    @Test
    void create() {
        PlaneProcessing planeProcessing = new PlaneProcessing();
        service.create(planeProcessing);
        Mockito.verify(dao, Mockito.times(1)).create(planeProcessing);
    }
    @Test
    void readAll() {
        service.readAll();
        Mockito.verify(dao, Mockito.times(1)).readAll();
    }

}