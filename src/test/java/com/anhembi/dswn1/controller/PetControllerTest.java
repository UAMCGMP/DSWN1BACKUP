package com.anhembi.dswn1.controller;

import com.anhembi.dswn1.domain.pet.Pet;
import com.anhembi.dswn1.domain.pet.PetDTO;
import com.anhembi.dswn1.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    private PetRepository repository;

    @InjectMocks
    private PetController petController;

    @Test
    void testGetPetByIdWhenPetExists() {
        // Given
        String petId = "1";
        Pet pet = new Pet();
        pet.setId(petId);

        when(repository.findById(petId)).thenReturn(Optional.of(pet));

        // When
        ResponseEntity result = petController.getPetById(petId);

        // Then
        assertEquals(ResponseEntity.ok(Optional.of(pet)), result);
    }

    @Test
    void testGetPetByIdWhenPetDoesNotExist() {
        // Given
        String petId = "1";

        when(repository.findById(petId)).thenReturn(Optional.empty());

        // When
        ResponseEntity result = petController.getPetById(petId);

        // Then
        assertEquals(ResponseEntity.notFound().build(), result);
    }

    @Test
    void testGetAllPetsWhenPetsExist() {
        // Given
        List<Pet> petList = new ArrayList<>();
        petList.add(new Pet());

        when(repository.findAll()).thenReturn(petList);

        // When
        ResponseEntity result = petController.getAllPets();

        // Then
        assertEquals(ResponseEntity.ok(petList), result);
    }

    @Test
    void testGetAllPetsWhenNoPetsExist() {
        // Given
        List<Pet> petList = new ArrayList<>();

        when(repository.findAll()).thenReturn(petList);

        // When
        ResponseEntity result = petController.getAllPets();

        // Then
        assertEquals(ResponseEntity.notFound().build(), result);
    }

    @Test
    void testRegisterPetWhenRepositorySizeIsLessThan10() {
        // Given
        PetDTO petDTO = new PetDTO("id",  "name", 3,  "size",  4.0,  "bio",  "gender",  "vaccinated",  "castration",  "photourl");

        when(repository.findAll()).thenReturn(new ArrayList<>());

        // When
        ResponseEntity result = petController.registerPet(petDTO);

        // Then
        assertEquals(ResponseEntity.ok().build(), result);

        // Verify that the save method of repository is called with the expected argument
        ArgumentCaptor<Pet> captor = ArgumentCaptor.forClass(Pet.class);
        verify(repository).save(captor.capture());

        Pet savedPet = captor.getValue();
        // Add additional assertions about the saved pet if needed
    }

    @Test
    void testRegisterPetWhenRepositorySizeIs10OrMore() {
        // Given
        PetDTO petDTO = new PetDTO("id", "name", 3, "size", 4.0, "bio", "gender", "vaccinated", "castration", "photourl");

        when(repository.findAll()).thenReturn(new ArrayList<>(List.of(new Pet(), new Pet(), new Pet(), new Pet(), new Pet(), new Pet(), new Pet(), new Pet(), new Pet(), new Pet())));

        // When
        ResponseEntity result = petController.registerPet(petDTO);

        // Then
        assertEquals(ResponseEntity.badRequest().build(), result);

        // Verify that the save method of repository is not called
        verify(repository, never()).save(any());
    }
    @Test
    void testExcludePetWhenPetExists() {
        // Given
        String petId = "1";

        when(repository.findById(petId)).thenReturn(Optional.of(new Pet()));

        // When
        ResponseEntity result = petController.excludePet(petId);

        // Then
        assertEquals(ResponseEntity.ok().build(), result);

        // Verify that the delete method of repository is call
    }
}
