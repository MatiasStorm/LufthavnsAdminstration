package com.cph.adminstration.service;

import com.cph.adminstration.model.Gate;
import com.cph.adminstration.repository.dao.GateDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateService {
    private final GateDAO gateDAO;


    public GateService(GateDAO gateDAO) {
        this.gateDAO = gateDAO;
    }

    public Gate create(Gate gate) {return gateDAO.create(gate);}

    public List<Gate> readAll() {


        return  gateDAO.readAll();}

    public Gate getByID(Integer number){return  gateDAO.getByID(number);}


}
