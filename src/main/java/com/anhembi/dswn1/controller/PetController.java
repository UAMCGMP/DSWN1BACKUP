package com.anhembi.dswn1.controller;

import com.anhembi.dswn1.domain.pet.Pet;
import com.anhembi.dswn1.domain.pet.PetDTO;
import com.anhembi.dswn1.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity getPetById(@PathVariable String id){
        var pets = repository.findById(id);
        if (pets.isPresent()){
            return ResponseEntity.ok(pets);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity getAllPets(){
        var allPets = repository.findAll();
        if(allPets.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allPets);
    }

    @PostMapping
    public ResponseEntity registerPet(@RequestBody PetDTO petDTO){
        Pet pet = new Pet(petDTO);
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
            pet.setAge(petDTO.age());
            pet.setSize(petDTO.size());
            pet.setWeight(petDTO.weight());
            pet.setBio(petDTO.bio());
            pet.setGender(petDTO.gender());
            pet.setVaccinated(petDTO.vaccinated());
            pet.setCastration(petDTO.castration());
            pet.setPhotourl(petDTO.photourl());
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
