package com.cph.adminstration.service;

import com.cph.adminstration.model.Plane;
import com.cph.adminstration.repository.dao.PlaneDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {
    private final PlaneDAO planeDAO;


    public PlaneService(PlaneDAO planeDAO) {
        this.planeDAO = planeDAO;
    }

    public Plane create(Plane plane) {return  planeDAO.create(plane);}

    public List<Plane> readAll() {
        return planeDAO.readAll();
    }

    public Plane getByID(String iata) {return  planeDAO.getByID(iata);}





}
