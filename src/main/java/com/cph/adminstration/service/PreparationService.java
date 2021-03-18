package com.cph.adminstration.service;

import com.cph.adminstration.model.Preparation;
import com.cph.adminstration.repository.dao.PreparationDAO;
import org.springframework.stereotype.Service;

@Service
public class PreparationService {
    private final PreparationDAO preparationDAO;

    public PreparationService(PreparationDAO preparationDAO) { this.preparationDAO = preparationDAO; }

    public Preparation create (Preparation preparation){ return preparationDAO.create(preparation); }
    }


