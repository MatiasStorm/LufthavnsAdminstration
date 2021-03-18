package com.cph.adminstration.controller;

import com.cph.adminstration.model.Plane;
import com.cph.adminstration.service.PlaneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping ("/plane")

public class PlaneController {

    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

     @GetMapping
    public List<Plane> getPlane() {return planeService.readAll();}

    @GetMapping("/{iataId}")
    public Plane getPlane(@PathVariable("iataId") String iataId) {return planeService.getByID(iataId);}

     @PostMapping()
    public ResponseEntity<Plane> createPlane(@RequestBody Plane plane) {
        Plane planeResponse = planeService.create(plane);
        return  new ResponseEntity<Plane>(planeResponse, HttpStatus.CREATED);
     }
}
