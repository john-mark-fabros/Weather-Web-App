package com.example.fullstackproject.backend.entity;

/*
 * John Mark A. Fabros
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    // attributes
    private Integer id;
    private String name;
    private int temp;

}
