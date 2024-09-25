package com.leoDuarte37.Patterns_Spring.business;

import com.leoDuarte37.Patterns_Spring.api.request.user.UpdateAddressFromUserRequest;
import com.leoDuarte37.Patterns_Spring.api.request.user.UserRequest;
import com.leoDuarte37.Patterns_Spring.api.response.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<UserResponse> save(UserRequest userRequest);
    ResponseEntity<List<UserResponse>> getAll();
    ResponseEntity<UserResponse> getByEmail(String email);
    ResponseEntity<UserResponse> updateAddress(UpdateAddressFromUserRequest updateAddressFromUserRequest);
    void deleteByEmail(String email);
}
