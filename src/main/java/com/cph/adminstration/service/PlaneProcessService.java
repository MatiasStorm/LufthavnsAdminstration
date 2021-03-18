package com.cph.adminstration.service;

import com.cph.adminstration.model.Arrival;
import com.cph.adminstration.model.PlaneProcess;
import com.cph.adminstration.repository.dao.PlaneProcessDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneProcessService {
    private final PlaneProcessDAO planeProcessDAO;

    public PlaneProcessService(PlaneProcessDAO planeProcessDAO) { this.planeProcessDAO = planeProcessDAO; }

    public PlaneProcess create (PlaneProcess planeProcess){ return planeProcessDAO.create(planeProcess); }

    public List<PlaneProcess> readAll() {
        List<PlaneProcess> planeProcesses = new ArrayList<>();
        for (PlaneProcess planeProcess : planeProcessDAO.readAll()) {
            planeProcesses.add(planeProcess);
        }
        return planeProcesses;
    }
    }


