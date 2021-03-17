package com.cph.adminstration.controller;

import com.cph.adminstration.model.Gate;
import com.cph.adminstration.service.GateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping ("/gate")

public class GateController {

    private final GateService gateService;


    public GateController(GateService gateService) {
        this.gateService = gateService;
    }

    @GetMapping()
    public List<Gate> getGate() {return gateService.readAll();}

    @GetMapping("/{gateId}")
    public Gate getGate(@PathVariable("gateId") int gateId) {return gateService.getByID(gateId); }

    @PostMapping()
    public ResponseEntity<Gate> createGate(@RequestBody Gate gate){
        Gate gateResponse = gateService.create(gate);
        return new ResponseEntity<Gate>(gateResponse, HttpStatus.CREATED);
    }


}
