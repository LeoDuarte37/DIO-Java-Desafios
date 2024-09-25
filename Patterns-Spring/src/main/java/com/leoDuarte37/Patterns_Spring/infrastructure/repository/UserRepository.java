package com.leoDuarte37.Patterns_Spring.infrastructure.repository;

import com.leoDuarte37.Patterns_Spring.infrastructure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM tb_user WHERE contact_email LIKE :email")
    Optional<User> findByEmail(@Param("email") String email);
}
