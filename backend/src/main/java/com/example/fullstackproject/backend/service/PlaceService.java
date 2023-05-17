package com.example.fullstackproject.backend.service;

import com.example.fullstackproject.backend.entity.Place;
import com.example.fullstackproject.backend.repository.PlaceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
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
        if (place.isPresent()) {
            return place.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place does not exist");
        }
    }

    // FETCH BY PLACE
    public List<Place> getByPlace(String place) {
        return repository.findAllByName(StringUtils.capitalize(place));
    }

    // ADD NEW PLACE
    public Place save(Place place) {
        // this is to ensure that all place name will have the same format
        Place temp = new Place(place.getId(), StringUtils.capitalize(place.getName()), place.getTemp());
        return repository.save(temp);
    }

    // DELETE PLACE
    public void delete(Integer id) {
        Optional<Place> temp = repository.findById(id);
        if (temp.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // PUT PLACE
    public Place put(Integer id, Place place) {
        Optional<Place> temp = repository.findById(id);
        if (temp.isPresent()) {
            Place updatePlace = repository.findById(id).get(); // fetch Place and assign to temporary Place;
            if (place.getName() != null && !place.getName().isEmpty()) {
                updatePlace.setName(place.getName());
            }
            if (place.getTemp() != null) {
                updatePlace.setTemp(place.getTemp());
            }
            return repository.save(updatePlace);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
