package com.cph.adminstration.controller;
import com.cph.adminstration.model.Arrival;
import com.cph.adminstration.service.ArrivalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/arrival")
@RestController
public class ArrivalController {

    private final ArrivalService arrivalService;

    public ArrivalController(ArrivalService arrivalService){
        this.arrivalService = arrivalService;
    }

    @GetMapping()
    public List<Arrival> getArrivals() {
        return arrivalService.readAll();
    }

    @PostMapping()
    //Herunder bliver produktet lavet til et objekt og fyldes ud med data fra Json
    public ResponseEntity<Arrival> createArrival(@RequestBody Arrival arrival){
        //Får vi productet tilbage med ID, efter ændring i repository create og service, som vi lige har oprettet
        Arrival arrivalResponse = arrivalService.create(arrival);
        //Her returneres en responseentity, der gør det muligt at definere Http statussen - som viser om man overholder reglerne for en rest controller.
        return new ResponseEntity<Arrival>(arrivalResponse, HttpStatus.CREATED);

    }

    //Put mapping bruges til at ændre på et objekt
    @PutMapping("")
    //Herunder bliver produktet lavet til et objekt og fyldes ud med data fra Json
    public Arrival putArrival(@RequestBody Arrival arrival) {
        // Smid alt fra vores Json ned i en update metode og skift det man har ændret i produktet
        arrivalService.update(arrival);
        return arrival;
    }
}
