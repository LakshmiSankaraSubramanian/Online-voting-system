package net.guides.springboot2.crud.controller;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.Contestant;
import net.guides.springboot2.crud.repository.ContestantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ContestantController {
    @Autowired
    private ContestantRepo contestantRepo;

    @GetMapping("/hacker")
    public List<Contestant> getAllHackers() {
        return contestantRepo.findAll();
    }

    @GetMapping("/hacker/{id}")
    public ResponseEntity<Contestant> getHackerByID(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        Contestant hacker = contestantRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(hacker);
    }

    @PostMapping(path="/hacker",  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Contestant createHacker(Contestant hacker) {
        return contestantRepo.save(hacker);
    }

    @PutMapping("/hacker/{id}")
    public ResponseEntity<Contestant> updateHacker(@PathVariable(value = "id") long userId) throws ResourceNotFoundException {
        Contestant hacker = contestantRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        hacker.setVotecount(hacker.getVotecount() + 1);
        final Contestant updateHacker = contestantRepo.save(hacker);
        return ResponseEntity.ok(updateHacker);
    }
}
