package com.anhembi.dswn1.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
