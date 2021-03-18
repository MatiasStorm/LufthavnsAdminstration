package com.cph.adminstration.service;

import com.cph.adminstration.model.PlaneProcess;
import com.cph.adminstration.repository.dao.PlaneProcessDAO;
import org.springframework.stereotype.Service;

@Service
public class PlaneProcessService {
    private final PlaneProcessDAO planeProcessDAO;

    public PlaneProcessService(PlaneProcessDAO planeProcessDAO) { this.planeProcessDAO = planeProcessDAO; }

    public PlaneProcess create (PlaneProcess planeProcess){ return planeProcessDAO.create(planeProcess); }
    }


