package com.example.bachelorapi.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contestant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //declaring what the contestant will consist of
    private Long id;
    private String name;
    private int age;
    private String Occupation;
    private String season;

}
