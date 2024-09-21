package com.leoDuarte37.Patterns_Spring.api.request;

import com.leoDuarte37.Patterns_Spring.infrastructure.model.Contact;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(

        @NotBlank
        String name,

        @NotNull
        Contact contact,

        @NotBlank
        String cep
    ) {
}
