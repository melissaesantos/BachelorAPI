package com.example.bachelorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bachelorapi.model.Contestant;
// this repository will manage 'contestant' enteties and the type of the primary key ('id') is Long
public interface ContestantRepository extends JpaRepository<Contestant, Long> {
    //add custom query methods
}
