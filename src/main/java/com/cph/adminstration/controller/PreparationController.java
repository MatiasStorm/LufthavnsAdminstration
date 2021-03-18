package com.cph.adminstration.controller;

import com.cph.adminstration.model.Preparation;
import com.cph.adminstration.service.PreparationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping ("/preparation")
@RestController
public class PreparationController {
    private final PreparationService preparationService;

    public PreparationController(PreparationService preparationService) { this.preparationService = preparationService; }

    @PostMapping()
    public ResponseEntity<Preparation> createProduct(@RequestBody Preparation preparation){

        Preparation preparationResponse = preparationService.create(preparation);

        return new ResponseEntity<Preparation>(preparationResponse, HttpStatus.CREATED);
    }
}
