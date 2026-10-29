package com.projeto.digimon.integration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DigimonResponse(
        String id,
        @JsonProperty("name") String nome,
        Boolean xAntibody
) {}
