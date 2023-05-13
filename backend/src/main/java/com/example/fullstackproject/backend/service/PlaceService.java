package com.example.fullstackproject.backend.service;

import com.example.fullstackproject.backend.entity.Place;
import com.example.fullstackproject.backend.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
