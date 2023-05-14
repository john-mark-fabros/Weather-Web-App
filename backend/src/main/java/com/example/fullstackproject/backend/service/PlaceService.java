package com.example.fullstackproject.backend.service;

import com.example.fullstackproject.backend.entity.Place;
import com.example.fullstackproject.backend.repository.PlaceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/*
 * John Mark A. Fabros
 */
@Service
public class PlaceService {

    private final PlaceRepository repository;

    public PlaceService(PlaceRepository repository) {
        this.repository = repository;
    }

    // GET ALL PLACE
    public List<Place> getAllPlace() {
        return repository.findAll();
    }

    // GET SPECIFIC PLACE BY ID
    public Place getById(Integer id) {
        Optional<Place> place = repository.findById(id);
        if(place.isPresent()) {
            return place.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // FETCH BY PLACE
    public List<Place> getByPlace(String place) {
        return repository.findAllByPlace(place);
    }
}
