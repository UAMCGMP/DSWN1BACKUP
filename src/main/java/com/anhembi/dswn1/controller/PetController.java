package com.anhembi.dswn1.controller;

import com.anhembi.dswn1.repository.PetRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetRepository repository;

    /*@GetMapping("/{id}")
    public ResponseEntity getPetById(){
        var allPets = repository.findAll();
        return ResponseEntity.ok(allPets);
    }*/

    @GetMapping
    public ResponseEntity getAllPets(){
        var allPets = repository.findAll();
        return ResponseEntity.ok(allPets);
    }

    @PostMapping
    public void postPet(){

    }

    @PutMapping
    public void editPetInfo(){

    }

    @DeleteMapping
    public void excludePet(){

    }

}
