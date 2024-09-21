package com.leoDuarte37.Patterns_Spring.api.mapper;

import com.leoDuarte37.Patterns_Spring.api.request.UserRequest;
import com.leoDuarte37.Patterns_Spring.api.response.UserResponse;
import com.leoDuarte37.Patterns_Spring.infrastructure.model.Address;
import com.leoDuarte37.Patterns_Spring.infrastructure.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private User.Builder builder = new User.Builder();

    public User toEntity(UserRequest userRequest, Address address) {
        return builder
                .name(userRequest.name())
                .contact(userRequest.contact())
                .address(address)
                .build();
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getName(),
                user.getContact(),
                user.getAddress()
        );
    }

    public User toUpdateAddress(User user, Address address) {
        return builder
                .id(user.getId())
                .name(user.getName())
                .contact(user.getContact())
                .address(address)
                .build();
    }
}
