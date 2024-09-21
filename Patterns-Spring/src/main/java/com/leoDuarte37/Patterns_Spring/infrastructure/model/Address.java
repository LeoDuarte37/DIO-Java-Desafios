package com.leoDuarte37.Patterns_Spring.infrastructure.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    private final String cep;
    private final String street;
    private final String neighborhood;
    private final String uf;
    private final String state;
    private final String region;
    private final String ddd;

    protected Address() {
        cep = null;
        street = null;
        neighborhood = null;
        uf = null;
        state = null;
        region = null;
        ddd = null;
    }

    private Address(Builder builder) {
        cep = builder.cep;
        street = builder.street;
        neighborhood = builder.neighborhood;
        uf = builder.uf;
        state = builder.state;
        region = builder.region;
        ddd = builder.ddd;
    }

    public String getCep() {
        return cep;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getUf() {
        return uf;
    }

    public String getState() {
        return state;
    }

    public String getRegion() {
        return region;
    }

    public String getDdd() {
        return ddd;
    }

    public static class Builder {
        private String cep;
        private String street;
        private String neighborhood;
        private String uf;
        private String state;
        private String region;
        private String ddd;

        public Builder() {}

        public Address build() {
            return new Address(this);
        }

        public Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

        public Builder uf(String uf) {
            this.uf = uf;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public Builder ddd(String ddd) {
            this.ddd = ddd;
            return this;
        }
    }
}
