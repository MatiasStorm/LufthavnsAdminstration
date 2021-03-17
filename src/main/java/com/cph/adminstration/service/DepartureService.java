package com.cph.adminstration.service;

import com.cph.adminstration.model.Departure;
import com.cph.adminstration.repository.dao.DepartureDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DepartureService {
    private final DepartureDAO departureDAO;

    public DepartureService(DepartureDAO departureDAO){
        this.departureDAO = departureDAO;
    }

    public Departure create(Departure departure) {
        return departureDAO.create(departure);
    }

    public List<Departure> readAll() {
        List<Departure> departures = new ArrayList<>();
        for (Departure departure : departureDAO.readAll()) {
            departures.add(departure);
        }
        return departures;
    }

}
