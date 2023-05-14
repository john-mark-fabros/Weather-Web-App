package com.example.fullstackproject.backend.controller;

/*
 * John Mark A. Fabros
 */

import com.example.fullstackproject.backend.entity.Place;
import com.example.fullstackproject.backend.service.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/weather")
public class PlaceController {

    private final PlaceService service;

    public PlaceController(PlaceService service) {
        this.service = service;
    }

    // GET MAPPING
    @GetMapping
    public ResponseEntity<List<Place>> getAllPlace() {
        if(service.getAllPlace().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(service.getAllPlace(), HttpStatus.OK);
        }
    }
}
