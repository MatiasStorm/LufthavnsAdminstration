package com.cph.adminstration.service;

import com.cph.adminstration.model.Arrival;
import com.cph.adminstration.repository.dao.ArrivalDAO;
import org.springframework.stereotype.Service;


@Service
public class ArrivalService {
    private final ArrivalDAO arrivalDAO;

    public ArrivalService(ArrivalDAO arrivalDAO){
        this.arrivalDAO = arrivalDAO;
    }


    public Arrival create(Arrival arrival) {
        return arrivalDAO.create(arrival);
    }

}
