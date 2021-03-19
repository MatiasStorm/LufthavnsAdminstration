package com.cph.adminstration.service;

import com.cph.adminstration.model.PlaneProcessing;
import com.cph.adminstration.repository.dao.PlaneProcessingDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneProcessingService {
    private final PlaneProcessingDAO planeProcessingDAO;

    public PlaneProcessingService(PlaneProcessingDAO planeProcessingDAO) { this.planeProcessingDAO = planeProcessingDAO; }

    public PlaneProcessing create (PlaneProcessing planeProcessing){ return planeProcessingDAO.create(planeProcessing); }

    public List<PlaneProcessing> readAll() {
        List<PlaneProcessing> planeProcessings = new ArrayList<>();
        for (PlaneProcessing planeProcessing : planeProcessingDAO.readAll()) {
            planeProcessings.add(planeProcessing);
        }
        return planeProcessings;
    }
    }


