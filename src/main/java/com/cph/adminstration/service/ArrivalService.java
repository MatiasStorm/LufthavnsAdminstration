package com.cph.adminstration.service;

import com.cph.adminstration.model.Arrival;
import com.cph.adminstration.repository.dao.ArrivalDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ArrivalService {
    private final ArrivalDAO arrivalDAO;

    public ArrivalService(ArrivalDAO arrivalDAO){
        this.arrivalDAO = arrivalDAO;
    }

    public Arrival create(Arrival arrival) {
        return arrivalDAO.create(arrival);
    }

    public void update(Arrival arrival) { arrivalDAO.update(arrival);
    }

    public List<Arrival> readAll() {
        List<Arrival> arrivals = new ArrayList<>();
        for (Arrival arrival : arrivalDAO.readAll()) {
            arrivals.add(arrival);
        }
        return arrivals;
    }

    public Arrival getArrival(Integer id) {
        return arrivalDAO.getByID(id);
    }

}
