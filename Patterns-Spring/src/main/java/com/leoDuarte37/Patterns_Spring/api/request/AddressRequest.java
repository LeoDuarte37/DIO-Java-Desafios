package com.leoDuarte37.Patterns_Spring.api.request;

public record AddressRequest(

        String cep,
        String logradouro,
        String bairro,
        String uf,
        String estado,
        String regiao,
        String ddd
    ) {
}
