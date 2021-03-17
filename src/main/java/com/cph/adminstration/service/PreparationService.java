package com.cph.adminstration.service;

import com.cph.adminstration.model.Arrival;
import com.cph.adminstration.model.Preparation;
import com.cph.adminstration.repository.dao.PreparationDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreparationService {
    private final PreparationDAO preparationDAO;

    public PreparationService(PreparationDAO preparationDAO) { this.preparationDAO = preparationDAO; }

    public Preparation create (Preparation preparation){ return preparationDAO.create(preparation); }

    public List<Preparation> readAll() {
        List<Preparation> preparations = new ArrayList<>();
        for (Preparation preparation : preparationDAO.readAll()) {
            preparations.add(preparation);

        }
        return preparations;
    }
    }


