package com.anhembi.dswn1.controller;

import com.anhembi.dswn1.domain.userApplication.UserAdoptionApplication;
import com.anhembi.dswn1.domain.userApplication.UserAdoptionApplicationDTO;
import com.anhembi.dswn1.repository.UserAdoptionApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adoptionApplication")
public class AdoptionApplicationController {
    @Autowired
    private UserAdoptionApplicationRepository userAdoptionApplicationRepository;

    @PostMapping
    public ResponseEntity application(@RequestBody UserAdoptionApplicationDTO data){
        userAdoptionApplicationRepository.save(
                new UserAdoptionApplication().builder()
                .emailUsuario(data.emailUsuario())
                .nomeUsuario(data.nomeUsuario())
                .telefoneUsuario(data.telefoneUsuario())
                .idPet(data.idPet())
                .nomeDoPet(data.nomeDoPet())
                .build()
        );
        return ResponseEntity.ok().build();
    }
}
