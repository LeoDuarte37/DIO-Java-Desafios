package com.leoDuarte37.Patterns_Spring.api.response;

import com.leoDuarte37.Patterns_Spring.infrastructure.model.Address;
import com.leoDuarte37.Patterns_Spring.infrastructure.model.Contact;
import com.leoDuarte37.Patterns_Spring.infrastructure.model.User;

public record UserResponse(

        String name,
        Contact contact,
        Address address
    ) {

    public static class Mapper {
        public static UserResponse from (User user) {
            return new UserResponse(
                    user.getName(),
                    user.getContact(),
                    user.getAddress()
            );
        }
    }
}
