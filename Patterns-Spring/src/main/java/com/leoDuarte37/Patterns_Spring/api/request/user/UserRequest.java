package com.leoDuarte37.Patterns_Spring.api.request.user;

import com.leoDuarte37.Patterns_Spring.infrastructure.model.Address;
import com.leoDuarte37.Patterns_Spring.infrastructure.model.Contact;
import com.leoDuarte37.Patterns_Spring.infrastructure.model.User;
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

    private static User.Builder builder = new User.Builder();

    public static User to (UserRequest userRequest, Address address) {
        return builder
                .name(userRequest.name())
                .contact(userRequest.contact())
                .address(address)
                .build();
    }
}
