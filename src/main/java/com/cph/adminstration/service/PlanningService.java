package com.cph.adminstration.service;

import com.cph.adminstration.model.Arrival;
import com.cph.adminstration.model.PlaneProcessingType;
import com.cph.adminstration.repository.dao.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanningService {
    private PlaneProcessingDAO planeProcessingDAO;
    private PlaneProcessingTypeDAO planeProcessingTypeDAO;
    private TravelProcessingDAO travelProcessingDAO;
    private TravelProcessTypeDAO travelProcessTypeDAO;
    private ArrivalDAO arrivalDAO;
    private List<PlaneProcessingType> processingTypes;

    public PlanningService(PlaneProcessingDAO planeProcessingDAO, TravelProcessingDAO travelProcessingDAO, ArrivalDAO arrivalDAO){
        this.planeProcessingDAO = planeProcessingDAO;
        this.travelProcessingDAO = travelProcessingDAO;
        this.arrivalDAO = arrivalDAO;
        processingTypes = planeProcessingTypeDAO.readAll();
    }

    public void createPlaneProcessings(Arrival arrival){
    }

   public void createPlan(){
       List<Arrival> arrivals = arrivalDAO.readAll();
       for(Arrival a : arrivals){
           createPlaneProcessings(a);
       }
   }
}
