package com.cph.adminstration.controller;

import com.cph.adminstration.model.PlaneProcess;
import com.cph.adminstration.service.PlaneProcessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping ("/planeProcess")
@RestController
public class PlaneProcessController {
    private final PlaneProcessService planeProcessService;

    public PlaneProcessController(PlaneProcessService planeProcessService) { this.planeProcessService = planeProcessService; }

    @PostMapping()
    public ResponseEntity<PlaneProcess> createProduct(@RequestBody PlaneProcess planeProcess){

        PlaneProcess planeProcessResponse = planeProcessService.create(planeProcess);

        return new ResponseEntity<PlaneProcess>(planeProcessResponse, HttpStatus.CREATED);
    }
}
