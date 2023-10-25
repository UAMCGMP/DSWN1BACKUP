package com.anhembi.dswn1.repository;

import com.anhembi.dswn1.domain.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {
}
