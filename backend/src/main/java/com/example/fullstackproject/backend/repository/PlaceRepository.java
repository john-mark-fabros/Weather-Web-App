package com.example.fullstackproject.backend.repository;

import com.example.fullstackproject.backend.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * John Mark A. Fabros
 */
public interface PlaceRepository extends JpaRepository<Place, Integer> {

    // fetch by place
    List<Place> findAllByName(String name);
}
