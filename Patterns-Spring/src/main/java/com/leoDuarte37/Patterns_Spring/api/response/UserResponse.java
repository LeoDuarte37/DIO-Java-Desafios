package com.leoDuarte37.Patterns_Spring.api.response;

import com.leoDuarte37.Patterns_Spring.infrastructure.model.Address;
import com.leoDuarte37.Patterns_Spring.infrastructure.model.Contact;

public record UserResponse(

        String name,
        Contact contact,
        Address address
    ) {
}
