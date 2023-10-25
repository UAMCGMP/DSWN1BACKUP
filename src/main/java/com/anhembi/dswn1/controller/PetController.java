package com.anhembi.dswn1.controller;

import com.anhembi.dswn1.domain.pet.Pet;
import com.anhembi.dswn1.domain.pet.PetDTO;
import com.anhembi.dswn1.repository.PetRepository;
import jakarta.transaction.Transactional;
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
    public ResponseEntity registerPet(@RequestBody PetDTO petDTO){
        Pet pet = new Pet(petDTO);
        System.out.println(petDTO);
        repository.save(pet);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePetInfo( @RequestBody PetDTO petDTO){
        var optionalPet = repository.findById(petDTO.id());
        if(optionalPet.isPresent()){
            Pet pet = optionalPet.get();
            pet.setName(petDTO.name());
            pet.setBio(petDTO.bio());
            repository.save(pet);
            return ResponseEntity.ok(pet);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity excludePet(@PathVariable String id){
        var pet = repository.findById(id);
        if (pet.isPresent()){
            repository.delete(pet.get());
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
