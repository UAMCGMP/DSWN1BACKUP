package com.anhembi.dswn1.controller;


import com.anhembi.dswn1.domain.user.AuthenticationDTO;
import com.anhembi.dswn1.domain.user.RegisterDTO;
import com.anhembi.dswn1.domain.user.User;
import com.anhembi.dswn1.domain.user.UserRole;
import com.anhembi.dswn1.infra.security.TokenService;
import com.anhembi.dswn1.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AuthenticationControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private AuthenticationController authenticationController;

    @Test
    void testLogin() {
        // Given
        AuthenticationDTO testData = new AuthenticationDTO("testUser","password" );
        User user = new User("testUser", "encryptedPassword", UserRole.USER);

        when(authenticationManager.authenticate(any()))
                .thenReturn(new UsernamePasswordAuthenticationToken(user, "encryptedPassword"));
        when(tokenService.generateToken(user)).thenReturn("generatedToken");

        // When
        ResponseEntity result = authenticationController.login(testData);

        // Then
        assertEquals(ResponseEntity.ok().body("generatedToken"), result);
    }

    @Test
    void testRegister() {
        // Given
        RegisterDTO testData = new RegisterDTO("newAdmin", "password", UserRole.ADMIN);

        when(userRepository.findByLogin("newAdmin")).thenReturn(null);
        // When
        ResponseEntity result = authenticationController.register(testData);
        // Then
        assertEquals(ResponseEntity.ok().build(), result);

        // Verify that the save method of userRepository is called with the expected argument
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(captor.capture());

        User newUser = captor.getValue();
        assertEquals("newAdmin", newUser.getLogin());
        assertTrue(new BCryptPasswordEncoder().matches("password", newUser.getPassword()));
        assertEquals(UserRole.ADMIN, newUser.getRole());
    }

    @Test
    void testRegisterUser() {
        // Given
        RegisterDTO testData = new RegisterDTO("newUser", "password", UserRole.USER);


        when(userRepository.findByLogin("newUser")).thenReturn(null);

        // When
        ResponseEntity result = authenticationController.registerUser(testData);

        // Then
        assertEquals(ResponseEntity.ok().build(), result);

        // Verify that the save method of userRepository is called with the expected argument
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(captor.capture());

        User newUser = captor.getValue();
        assertEquals("newUser", newUser.getLogin());
        assertTrue(new BCryptPasswordEncoder().matches("password", newUser.getPassword()));
        assertEquals(UserRole.USER, newUser.getRole());
    }
}
