package com.projeto.digimon.controller;

import com.projeto.digimon.controller.adapter.DigimonControllerAdapter;
import com.projeto.digimon.controller.dto.response.DigimonResponse;
import com.projeto.digimon.entity.Digimon;
import com.projeto.digimon.integration.DigimonIntegration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DigimonController {

    private final DigimonIntegration digimonIntegration;

    public DigimonController(DigimonIntegration digimonIntegration) {
        this.digimonIntegration = digimonIntegration;
    }

    @GetMapping("/digimon/{id}")
    public DigimonResponse pesquisar(@PathVariable String id) {
        Digimon digimon = digimonIntegration.buscarDigimon(id);
        return DigimonControllerAdapter.castResponse(digimon);
    }
}


