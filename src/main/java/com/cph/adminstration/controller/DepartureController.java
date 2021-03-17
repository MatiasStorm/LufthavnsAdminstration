package com.cph.adminstration.controller;
import com.cph.adminstration.model.Departure;
import com.cph.adminstration.service.DepartureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/departure")
@RestController
public class DepartureController {

    private final DepartureService departureService;

    public DepartureController(DepartureService departureService){
        this.departureService = departureService;
    }

    @GetMapping()
    public List<Departure> getDepartures() {
        return departureService.readAll();
    }

    @PostMapping()
    //Herunder bliver produktet lavet til et objekt og fyldes ud med data fra Json
    public ResponseEntity<Departure> createDepartures(@RequestBody Departure departure){
        //Får vi productet tilbage med ID, efter ændring i repository create og service, som vi lige har oprettet
        Departure departureResponse = departureService.create(departure);
        //Her returneres en responseentity, der gør det muligt at definere Http statussen - som viser om man overholder reglerne for en rest controller.
        return new ResponseEntity<Departure>(departureResponse, HttpStatus.CREATED);

    }
}
