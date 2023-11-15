package com.anhembi.dswn1.domain.pet;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Table(name="pet")
@Entity(name="pet")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer age;
    private String size;
    private Double weight;
    private String bio;
    private String gender;
    private String vaccinated;
    private String castration;
    private String photourl;

    public Pet(PetDTO petDTO){
        this.name = petDTO.name();
        this.bio = petDTO.bio();
    }

}
