package com.example.fullstackproject.backend.controller;

/*
 * John Mark A. Fabros
 */

import com.example.fullstackproject.backend.entity.Place;
import com.example.fullstackproject.backend.service.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/weather")
public class PlaceController {

    private final PlaceService service;

    public PlaceController(PlaceService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Place>> getAllPlace() {
        if(service.getAllPlace().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(service.getAllPlace(), HttpStatus.OK);
        }
    }

    // GET BY ID
    @GetMapping(path = "/place/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable("id")  Integer id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    // FIND ALL BY PLACE
    @GetMapping(path = "/{place}")
    public ResponseEntity<List<Place>> getByPlace(@PathVariable("place") String place) {
        if(service.getByPlace(place).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(service.getByPlace(place), HttpStatus.OK);
        }
    }

    // ADD NEW PLACE
    @PostMapping
    public ResponseEntity<Place> savePlace(@Valid @RequestBody Place place) {
        try{
            return new ResponseEntity<>(service.save(place), HttpStatus.CREATED);
        } catch(ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // DELETE PLACE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePlace(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (ResponseStatusException e) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // PUT PLACE
    @PutMapping(path = "/{id}")
    public ResponseEntity<Place> putPlace(@PathVariable("id") Integer id, @RequestBody Place place) {
        try {
            return new ResponseEntity<>(service.put(id, place), HttpStatus.OK);
        } catch(ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
