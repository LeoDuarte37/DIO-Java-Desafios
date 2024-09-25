package com.leoDuarte37.Patterns_Spring.api;

import com.leoDuarte37.Patterns_Spring.api.request.user.UpdateUserAddressRequest;
import com.leoDuarte37.Patterns_Spring.api.request.user.UserRequest;
import com.leoDuarte37.Patterns_Spring.api.response.UserResponse;
import com.leoDuarte37.Patterns_Spring.business.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserResponse>> getAll() {
        return userService.getAll();
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserResponse> getByEmail(@PathVariable("email") @Email String email) {
        return userService.getByEmail(email);
    }

    @PatchMapping
    @Transactional
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<UserResponse> updateAddress(@RequestBody @Valid UpdateUserAddressRequest updateUserAddressRequest) {
        return userService.updateAddress(updateUserAddressRequest);
    }

    @DeleteMapping("/{email}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByEmail(@PathVariable("email") @Email String email) {
        userService.deleteByEmail(email);
    }
}
