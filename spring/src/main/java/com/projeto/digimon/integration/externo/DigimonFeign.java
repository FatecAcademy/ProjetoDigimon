package com.projeto.digimon.integration.externo;

import com.projeto.digimon.integration.dto.DigimonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "DAPI",
        url = "${digi-api.url}"
)
public interface DigimonFeign {

    @GetMapping("/api/v1/digimon/{id}")
    DigimonResponse buscarDigimon(@PathVariable("id") String id);
}
