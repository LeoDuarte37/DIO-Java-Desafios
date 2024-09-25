package com.leoDuarte37.Patterns_Spring.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @NotBlank
    private final String name;

    @NotNull
    @OneToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST}, orphanRemoval = true)
    private final Contact contact;

    @NotNull
    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE})
    @JsonIgnoreProperties("user")
    private final Address address;

    protected User() {
        id = null;
        name = null;
        contact = null;
        address = null;
    }

    private User(Builder builder) {
        id = builder.id;
        name = builder.name;
        contact = builder.contact;
        address = builder.address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Contact contact;
        private Address address;

        public Builder() {}

        public User build() {
            return new User(this);
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder contact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }
    }
}
