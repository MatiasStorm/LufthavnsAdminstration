package com.cph.adminstration.service;

import com.cph.adminstration.model.Arrival;
import com.cph.adminstration.model.Preparation;
import com.cph.adminstration.repository.dao.PreparationDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PreparationServiceTest {

@Mock
    PreparationDAO dao;
    PreparationService service;

    @BeforeEach
    public void setup(){
        this.service = new PreparationService(dao);
    }

    @Test
    void create() {
        Preparation preparation = new Preparation();
        service.create(preparation);
        Mockito.verify(dao, Mockito.times(1)).create(preparation);
    }
    @Test
    void readAll() {
        service.readAll();
        Mockito.verify(dao, Mockito.times(1)).readAll();
    }



}




