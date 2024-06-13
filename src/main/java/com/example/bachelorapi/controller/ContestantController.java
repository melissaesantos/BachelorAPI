package com.example.bachelorapi.controller;

import com.example.bachelorapi.model.Contestant;
import com.example.bachelorapi.repository.ContestantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contestants")
public class ContestantController {

    @Autowired
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

    @PostMapping
    public Contestant createContestant(@RequestBody Contestant contestant) {
        return contestantRepository.save(contestant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contestant> updateContestant(@PathVariable Long id, @RequestBody Contestant contestantDetails) {
        return contestantRepository.findById(id)
                .map(contestant -> {
                    contestant.setName(contestantDetails.getName());
                    contestant.setAge(contestantDetails.getAge());
                    contestant.setOccupation(contestantDetails.getOccupation());
                    contestant.setSeason(contestantDetails.getSeason());
                    Contestant updatedContestant = contestantRepository.save(contestant);
                    return ResponseEntity.ok().body(updatedContestant);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContestant(@PathVariable Long id) {
        return contestantRepository.findById(id)
                .map(contestant -> {
                    contestantRepository.delete(contestant);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
