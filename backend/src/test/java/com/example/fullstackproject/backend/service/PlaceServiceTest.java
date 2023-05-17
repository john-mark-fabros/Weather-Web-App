package com.example.fullstackproject.backend.service;

import com.example.fullstackproject.backend.entity.Place;
import com.example.fullstackproject.backend.repository.PlaceRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        when(mockRepos.save(place)).thenReturn(place);
        assertEquals(place, mockService.save(place));
    }

    @Test
    public void test_save_place_return_conflict() {
        // negative
        Place err = new Place(null, null, null);
        when(mockRepos.save(err)).thenThrow(ResponseStatusException.class);
        assertThrows(ResponseStatusException.class, ()->{
            mockService.save(err);
        });
    }

    @Test
    public void test_get_place_by_id_return_ok() {
        // happy
        when(mockRepos.findById(1)).thenReturn(Optional.of(place));
        assertEquals("Philippines", mockService.getById(1).getName());

    }

    @Test
    public void test_get_place_by_id_return_not_found() {
        // negative
        when(mockRepos.findById(2)).thenThrow(ResponseStatusException.class);
        assertThrows(ResponseStatusException.class, ()->{
           mockService.getById(2);
        });
    }
//
//    @Test
//    public void test_delete_place_by_id_return_no_content() {
//        // happy
//        mockService.delete(1);
//        verify(mockRepos, times(1)).deleteById(1);
//    }
//
//    @Test
//    public void test_delete_place_by_id_return_not_found() {
//        // negative
//        mockService.delete(2);
//        verify(mockRepos, times(1)).delete(place);
//    }
}
