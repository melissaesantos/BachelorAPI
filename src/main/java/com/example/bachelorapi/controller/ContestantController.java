package com.example.bachelorapi.controller;

import com.example.bachelorapi.model.Contestant;
import com.example.bachelorapi.repository.ContestantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contestants")
public class ContestantController {
    @Autowired
    //allows the controller to use the repository for CRUD operations on the 'Contestant' entity
    private ContestantRepository contestantRepository;

    @GetMapping
    public List<Contestant> getAllContestants() {
        return contestantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contestant> getContestantById(@PathVariable Long id) {
        return contestantRepository.findById(id)
                .map(contestant -> ResponseEntity.ok().body(contestant))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping("/{id}")
    public Contestant createContestant(@RequestBody Contestant contestant) {
        return contestantRepository.save(contestant);
    }


}
