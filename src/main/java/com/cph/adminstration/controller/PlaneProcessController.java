package com.cph.adminstration.controller;

import com.cph.adminstration.model.PlaneProcessing;
import com.cph.adminstration.service.PlaneProcessingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping ("/planeProcess")
@RestController
public class PlaneProcessController {
    private final PlaneProcessingService planeProcessingService;

    public PlaneProcessController(PlaneProcessingService planeProcessingService) { this.planeProcessingService = planeProcessingService; }

    @PostMapping()
    public ResponseEntity<PlaneProcessing> createProduct(@RequestBody PlaneProcessing planeProcessing){

        PlaneProcessing planeProcessingResponse = planeProcessingService.create(planeProcessing);

        return new ResponseEntity<PlaneProcessing>(planeProcessingResponse, HttpStatus.CREATED);
    }
}
