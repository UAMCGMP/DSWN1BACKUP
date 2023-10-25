package com.anhembi.dswn1.domain.pet;

import jakarta.persistence.Id;

public record PetDTO(String id, String name, String bio) {
}
