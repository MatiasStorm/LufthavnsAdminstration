package com.cph.adminstration.model;

import com.cph.adminstration.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaneParking {
    //Key = gateNumber   Value = isVacant
    private static HashMap<Integer, Boolean> gateStatus;
    private static HashMap<Integer, Plane> planesAtGate;
    private static ArrayList<Plane> planesParked;
    @Autowired
    private GateService gateService;
    private List<Gate> gates = gateService.readAll();
    
    
    public String findGate(Plane plane){
        if (gateStatus == null){
            gateStatus = new HashMap<>();
            for (int i = 1; i < 27; i++) {
                if (i == 13 || i == 14){
                    break;
                }
                gateStatus.put(i, true);
            }

        }
        String vacantGateNumber = "There are no vacant gates that fit this size plane atm (ass to mouth)";
        for (Gate gate: gates) {
            if (gate.getGateSize() == plane.getPlaneSize() && gateStatus.get(gate.getNumber())){
                if (planesAtGate == null){
                    planesAtGate = new HashMap<>();
                }
                planesAtGate.put(gate.getNumber() ,plane);
                gateStatus.replace(gate.getNumber(), false);
                vacantGateNumber = "The plane is docked at gate: " + gate.getNumber();
            }
        }
        return vacantGateNumber;
    }

    public String removeToDeparture(int gateNumber){
        planesAtGate.remove(gateNumber);
        gateStatus.replace(gateNumber, true);
        return "Plane at gate: " + gateNumber + " is departed";
        }

        public String removeToParking(int gateNumber){
        planesAtGate.remove(gateNumber);
        gateStatus.replace(gateNumber, true);
        if (planesParked == null){
            planesParked = new ArrayList<>();
        }
        planesParked.add(planesAtGate.get(gateNumber));
        return "Plane at gate: " + gateNumber + " is parked";
        }

//        public String changeGate(int gateNumber){
//            if (gateStatus.get(gateNumber)){
//                planesAtGate
//            }
//        }
    }





