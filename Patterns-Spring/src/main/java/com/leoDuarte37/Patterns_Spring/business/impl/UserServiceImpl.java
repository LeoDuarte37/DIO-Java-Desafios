package com.leoDuarte37.Patterns_Spring.business.impl;

import com.leoDuarte37.Patterns_Spring.api.request.address.AddressRequest;
import com.leoDuarte37.Patterns_Spring.api.request.user.UpdateAddressFromUserRequest;
import com.leoDuarte37.Patterns_Spring.api.request.user.UserRequest;
import com.leoDuarte37.Patterns_Spring.api.response.UserResponse;
import com.leoDuarte37.Patterns_Spring.business.UserService;
import com.leoDuarte37.Patterns_Spring.business.ViaCepService;
import com.leoDuarte37.Patterns_Spring.infrastructure.model.Address;
import com.leoDuarte37.Patterns_Spring.infrastructure.model.User;
import com.leoDuarte37.Patterns_Spring.infrastructure.repository.AddressRepository;
import com.leoDuarte37.Patterns_Spring.infrastructure.repository.ContactRepository;
import com.leoDuarte37.Patterns_Spring.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public ResponseEntity<UserResponse> save(UserRequest userRequest) {
        if (contactRepository.existsById(userRequest.contact().getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "User with this email already exists!"
            );
        }

        Address address = verifyAddress(userRequest.cep());

        User user = UserRequest.to(userRequest, address);

        return ResponseEntity.ok(
                UserResponse.Mapper.from(userRepository.save(user))
        );
    }

    @Override
    public ResponseEntity<List<UserResponse>> getAll() {
        List<UserResponse> userResponseList = userRepository.findAll().stream()
                .map(UserResponse.Mapper::from)
                .toList();

        return ResponseEntity.ok(userResponseList);
    }

    @Override
    public ResponseEntity<UserResponse> getByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!");
        }

        UserResponse userResponse = UserResponse.Mapper.from(user.get());

        return ResponseEntity.ok(userResponse);
    }

    @Override
    public ResponseEntity<UserResponse> updateAddress(UpdateAddressFromUserRequest updateAddressFromUserRequest) {
        Optional<User> user = userRepository.findByEmail(updateAddressFromUserRequest.email());

        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!");
        }

        Address newAddress = verifyAddress(updateAddressFromUserRequest.newCep());
        User userUpdated = UpdateAddressFromUserRequest.to(user.get(), newAddress);

        return ResponseEntity.ok(
                UserResponse.Mapper.from(userRepository.save(userUpdated))
        );
    }

    @Override
    public void deleteByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!");
        }

        userRepository.deleteById(user.get().getId());
    }

    public Address verifyAddress(String cep) {
        return addressRepository.findById(cep)
                .orElseGet(() -> AddressRequest.to(
                        viaCepService.checkCep(cep)
                ));
    }
}
