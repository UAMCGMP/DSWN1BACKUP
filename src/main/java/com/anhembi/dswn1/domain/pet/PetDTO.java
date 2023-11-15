package com.anhembi.dswn1.domain.pet;

public record PetDTO(String id, String name,Integer age, String size, Double weight, String bio, String gender, String vaccinated, String castration, String photourl) {
}
