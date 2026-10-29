package com.projeto.digimon.integration;

import com.projeto.digimon.entity.Digimon;
import com.projeto.digimon.exception.DigimonNotFoundException;
import com.projeto.digimon.integration.externo.DigimonFeign;
import feign.FeignException;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;

@Component
public class DigimonIntegrationImpl implements DigimonIntegration {

    private final DigimonFeign digi;

    public DigimonIntegrationImpl(DigimonFeign digi) {
        this.digi = digi;
    }

    @Override
    @Retry(name = "DAPI", fallbackMethod = "fallback")
    public Digimon buscarDigimon(String id) {
        try {
            var response = digi.buscarDigimon(id);

            return new Digimon(
                    response.id(),
                    response.nome(),
                    Boolean.TRUE.equals(response.xAntibody()) ? 1 : 0
            );
        } catch (FeignException.NotFound e) {
            throw new DigimonNotFoundException(id);
        }
    }

    private Digimon fallback(String id, DigimonNotFoundException e) {
        throw e;
    }

    private Digimon fallback(String id, Throwable e) {
        return new Digimon("0", "Digimon indisponível", 0);
    }
}