package com.example.fullstackproject.backend.service;

import com.example.fullstackproject.backend.entity.Place;
import com.example.fullstackproject.backend.repository.PlaceRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/*
 * John Mark A. Fabros
 */
@SpringBootTest
public class PlaceServiceTest {

    @MockBean
    PlaceRepository mockRepos;

    @Autowired
    PlaceService mockService;

    static Place place;
    static List<Place> listPlace = new ArrayList<>();

    @BeforeAll
    public static void init() {
        place = new Place(1, "Philippines", 32);
        listPlace.add(place);
    }

    @Test
    public void test_get_all_place_return_ok() {
        // happy
        when(mockRepos.findAll()).thenReturn(listPlace);
        assertEquals(listPlace.size(), mockService.getAllPlace().size());
    }

    @Test
    public void test_get_all_place_return_no_content() {
        // negative
        when(mockRepos.findAll()).thenReturn(new ArrayList<>());
        assertEquals(0, mockService.getAllPlace().size());
    }

    @Test
    public void test_save_place_return_ok() {
        // happy
    }

    @Test
    public void test_save_place_return_conflict() {
        // negative
    }

    @Test
    public void test_get_place_by_id_return_ok() {
        // happy
    }

    @Test
    public void test_get_place_by_id_return_not_found() {
        // negative
    }

    @Test
    public void test_delete_place_by_id_return_no_content() {
        // happy
    }

    @Test
    public void test_delete_place_by_id_return_not_found() {
        // negative
    }
}
