package com.leoDuarte37.Patterns_Spring.infrastructure.repository;

import com.leoDuarte37.Patterns_Spring.infrastructure.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
