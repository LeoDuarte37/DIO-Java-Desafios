package com.leoDuarte37.Patterns_Spring.api.request.address;

import com.leoDuarte37.Patterns_Spring.infrastructure.model.Address;

public record AddressRequest(

        String cep,
        String logradouro,
        String bairro,
        String uf,
        String estado,
        String regiao,
        String ddd
    ) {

    private static Address.Builder builder = new Address.Builder();

    public static Address to (AddressRequest request) {
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
