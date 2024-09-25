package com.leoDuarte37.Patterns_Spring.business;

import com.leoDuarte37.Patterns_Spring.api.request.address.AddressRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    AddressRequest checkCep(@PathVariable("cep") String cep);
}
