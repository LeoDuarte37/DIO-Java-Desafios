package com.leoDuarte37.Patterns_Spring.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserRequest(

        @NotBlank
        @Email
        String email,

        @NotBlank
        String newCep
    ) {
}
