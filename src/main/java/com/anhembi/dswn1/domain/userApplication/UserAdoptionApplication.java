package com.anhembi.dswn1.domain.userApplication;

import jakarta.persistence.*;
import lombok.*;

@Table(name="userAdoptionApplication")
@Entity(name="userAdoptionApplication")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAdoptionApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nomeUsuario;
    private String emailUsuario;
    private String telefoneUsuario;
    private String idPet;
    private String nomeDoPet;
}
