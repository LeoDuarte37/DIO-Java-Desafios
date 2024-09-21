package com.leoDuarte37.Patterns_Spring.api.mapper;

import com.leoDuarte37.Patterns_Spring.api.request.AddressRequest;
import com.leoDuarte37.Patterns_Spring.infrastructure.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    private Address.Builder builder = new Address.Builder();

    public Address toEntity(AddressRequest request) {
        return builder
                    .cep(request.cep())
                    .street(request.logradouro())
                    .neighborhood(request.bairro())
                    .uf(request.uf())
                    .state(request.estado())
                    .region(request.regiao())
                    .ddd(request.ddd())
                    .build();
    }
}
