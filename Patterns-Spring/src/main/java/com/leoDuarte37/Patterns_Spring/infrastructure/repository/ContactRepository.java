package com.leoDuarte37.Patterns_Spring.infrastructure.repository;

import com.leoDuarte37.Patterns_Spring.infrastructure.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {
}
