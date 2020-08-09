package net.guides.springboot2.crud.controller;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class User {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public List<net.guides.springboot2.crud.model.User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<net.guides.springboot2.crud.model.User> getUserById(@PathVariable(value = "id") Long  userId)
            throws ResourceNotFoundException {
        net.guides.springboot2.crud.model.User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(path="/users", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public net.guides.springboot2.crud.model.User createUser( net.guides.springboot2.crud.model.User user) {
        return userRepo.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<net.guides.springboot2.crud.model.User> updateUser(@PathVariable(value = "id") long userId) throws ResourceNotFoundException {
        net.guides.springboot2.crud.model.User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setVote(1);
        final net.guides.springboot2.crud.model.User updatedUser = userRepo.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}
