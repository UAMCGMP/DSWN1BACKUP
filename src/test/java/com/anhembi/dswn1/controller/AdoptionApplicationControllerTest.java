package com.anhembi.dswn1.controller;

import com.anhembi.dswn1.domain.userApplication.UserAdoptionApplication;
import com.anhembi.dswn1.domain.userApplication.UserAdoptionApplicationDTO;
import com.anhembi.dswn1.repository.UserAdoptionApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class AdoptionApplicationControllerTest {
    @Mock
    private UserAdoptionApplicationRepository userAdoptionApplicationRepository;

    @InjectMocks
    private AdoptionApplicationController adoptionApplicationController;

    @Test
    void testApplication() {
        // Given
        UserAdoptionApplicationDTO testData = new UserAdoptionApplicationDTO("Test User","test@example.com", "123456789", "1","Pet Name" );
        // When
        ResponseEntity result = adoptionApplicationController.application(testData);
        // Then
        assertEquals(ResponseEntity.ok().build(), result);

        // Verify that the save method of userAdoptionApplicationRepository is called with the expected argument
        ArgumentCaptor<UserAdoptionApplication> captor = ArgumentCaptor.forClass(UserAdoptionApplication.class);
        verify(userAdoptionApplicationRepository).save(captor.capture());

        UserAdoptionApplication savedApplication = captor.getValue();
        assertEquals("test@example.com", savedApplication.getEmailUsuario());
        assertEquals("Test User", savedApplication.getNomeUsuario());
        assertEquals("123456789", savedApplication.getTelefoneUsuario());
        assertEquals("1", savedApplication.getIdPet());
        assertEquals("Pet Name", savedApplication.getNomeDoPet());
    }
}
