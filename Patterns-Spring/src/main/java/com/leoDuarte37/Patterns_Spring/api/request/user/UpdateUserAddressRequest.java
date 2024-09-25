package com.leoDuarte37.Patterns_Spring.api.request.user;

import com.leoDuarte37.Patterns_Spring.infrastructure.model.Address;
import com.leoDuarte37.Patterns_Spring.infrastructure.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserAddressRequest(

        @NotBlank
        @Email
        String email,

        @NotBlank
        String newCep
    ) {

    private static User.Builder builder = new User.Builder();

    public static User to (User user, Address address) {
        return builder
                .id(user.getId())
                .name(user.getName())
                .contact(user.getContact())
                .address(address)
                .build();
    }
}
